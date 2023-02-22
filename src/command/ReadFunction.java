package src.command;

import src.collection.CollectionManager;
import src.collection.LabWork;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static src.collection.CollectionManager.getCollection;


/**
 * Class for reading commands from input s;
 * <p>
 * uses regex;
 *
 * @see CommandsWithArguments
 */
public class ReadFunction {

    public void setCommands(Commands[] commands) {
        this.commands = commands;
    }

    Commands[] commands;
    Deque<Commands> last_commands = new LinkedList<>();

    public void read(String s) {
        String[] tokens = s.split(" ");
        Arrays.stream(commands)
                .filter(x -> x.getName().equals(tokens[0].trim()))
                .findFirst()
                .ifPresentOrElse(
                        x -> {
                            try {
                                if (x.hasArgument) {
                                    CommandsWithArguments<?> command_arg = (CommandsWithArguments<?>) x;
                                    command_arg.stringToArgument(tokens[tokens.length - 1].trim());
                                    command_arg.execute();
                                    last_commands.add(command_arg);
                                    tmpSave();
                                } else {
                                    switch (x.getName()) {
                                        case "exit" -> {
                                            if (!getLastCommands().isEmpty()) {
                                                String lastCommandName = getLastCommands().peekLast().getName();
                                                if (lastCommandName.equals("save")) {
                                                    last_commands.add(x);
                                                    BackgroundSaveCommand.deleteCrashFile();
                                                    x.execute();
                                                    break;

                                                } else if (Stream.of("clear", "remove_lower", "remove", "add_if_max", "add", "update")
                                                        .anyMatch(cmd -> cmd.equals(getLastCommands().peekLast().getName()))) {
                                                    System.out.println(" \u001B[31m Your data will be lost. \n Do you want to save it? (y/n)");
                                                    Scanner scanner = new Scanner(System.in);
                                                    String answer = scanner.nextLine();
                                                    if (answer.equals("y")) {
                                                        SaveCommand saveCommand = new SaveCommand(getCollection(), new File("late_collection_save.json"));
                                                        BackgroundSaveCommand.deleteCrashFile();
                                                        saveCommand.execute();

                                                    } else if (answer.equals("n")) {
                                                        last_commands.add(x);
                                                        BackgroundSaveCommand.deleteCrashFile();
                                                        x.execute();
                                                        break;
                                                    } else {
                                                        System.out.println(" \u001B[31m Please enter y or n");
                                                    }
                                                }
                                            }
                                            last_commands.add(x);
                                            BackgroundSaveCommand.deleteCrashFile();
                                            x.execute();
                                        }
                                        default -> {
                                            last_commands.add(x);
                                            x.execute();
                                            tmpSave();
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("\u001B[31m " + e.getMessage());
                            }
                        },
                        () -> {
                            System.out.println("\u001B[31m BITTE GEBEN SIE DEN RICHTIGEN BEFEHL EIN. ICH BIN ZU EINFACH, UM GEDANKEN ZU LESEN.");
                            System.out.println("\u001B[32m help : \u001B[0m show all commands");
                        });
    }

    public Deque<Commands> getLastCommands() {
        return last_commands;
    }


    private static void tmpSave() {
        BackgroundSaveCommand backgroundSaveCommand = new BackgroundSaveCommand(getCollection(), new File(Objects.requireNonNull(CollectionManager.getFile()).getName()));
        backgroundSaveCommand.execute();
    }

    /**
     * Class for command execution that converts string to argument
     *
     * @see CommandsWithArguments
     */
    public class ExecuteCommand extends CommandsWithArguments<String> {

        public ExecuteCommand(LinkedHashSet<LabWork> labWorks, File file) {
            super(labWorks, file);
            argumentName = "file_name";
            this.name = "execute_script";
            this.hasArgument = true;
        }

        private final List<File> FileArray = new ArrayList<>();

        @Override
        public void execute() {

            File script = new File(argument);

            if (!FileArray.contains(script)) {
                FileArray.add(script);
                try {
                    Scanner in_script = new Scanner(script);
                    while (in_script.hasNext()) {
                        read(in_script.nextLine());
                    }

//                    System.out.println(last_commands);

                } catch (FileNotFoundException e) {
                    System.out.println("\u001B[31m File not found");
                }
                FileArray.remove(script);
            } else {
                System.out.println("\u001B[31m ACHTUNG CHAOS UND REKURSION IST MÖGLICH SIE WURDEN DURCH DEN BLOCK GERETTET WENN SIE IHM DANKE SAGEN");
            }
        }

        @Override
        public String getDescription() {
            return "\u001B[32m execute_script file_name :\u001B[0m считать и исполнить скрипт из указанного файла.";
        }
    }
}