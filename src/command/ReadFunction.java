package src.command;

import src.collection.CollectionManager;
import src.collection.LabWork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static src.collection.CollectionManager.getCollection;


/**
 * Class for reading commands from input s;
 * <p>
 * uses regex;
 *
 * @see CommandsWithArguments
 */
public class ReadFunction {
    //        boolean canModify = (
//                (getLastCommands().stream().anyMatch(y -> y.getName().equals("add")))
//                        | (getLastCommands().stream().anyMatch(y -> y.getName().equals("update")))
//                        | (getLastCommands().stream().anyMatch(y -> y.getName().equals("remove")))
//                        | (getLastCommands().stream().anyMatch(y -> y.getName().equals("clear")))
//                        | (getLastCommands().stream().anyMatch(y -> y.getName().equals("add_if_max")))
//                        | (getLastCommands().stream().anyMatch(y -> y.getName().equals("remove_lower")))
//        );
    boolean canModify = (
            getLastCommands() != null && getLastCommands().peekLast().equals("clear")
    );


    public void setCommands(Commands[] commands) {
        this.commands = commands;
    }

    //    File tempFile = File.createTempFile("collectionBackup", ".json");
//    gson.toJson(getCollection(), new java.io.FileWriter(tempFile));
//    System.out.println("Temporary file is located on default location: " + tempFile.getAbsolutePath());
    Commands[] commands;
    Deque<Commands> last_commands = new LinkedList<>();

    public void read(String s) {

        Arrays.stream(commands)
                .filter(x -> x.getName().equals(s.split(" ")[0].trim()))
                .findFirst()
                .ifPresentOrElse(
                        x -> {
                            try {
                                if (x.hasArgument) {
                                    CommandsWithArguments<?> command_arg = (CommandsWithArguments<?>) x;
                                    command_arg.stringToArgument(s.split(" ")[s.split(" ").length - 1].trim());
                                    command_arg.execute();
                                    last_commands.add(command_arg);

                                } else if (x.getName().equals("exit")) {
                                    if (getLastCommands().size() != 0 && getLastCommands().peekLast().getName().equals("save")) {
                                        x.execute();
                                        last_commands.add(x);
                                        tmpSave();
                                    } else if ((getLastCommands().isEmpty())) {
                                        x.execute();
                                        last_commands.add(x);
                                        tmpSave();
                                    } else {
                                        if (getLastCommands().peekLast().getName().equals("save")) {
                                            x.execute();
                                            last_commands.add(x);
                                            tmpSave();
                                        } else if (getLastCommands().peekLast().getName().equals("clear")
                                                || getLastCommands().peekLast().getName().equals("remove_lower")
                                                || getLastCommands().peekLast().getName().equals("remove")
                                                || getLastCommands().peekLast().getName().equals("add_if_max")
                                                || getLastCommands().peekLast().getName().equals("add")
                                                || getLastCommands().peekLast().getName().equals("update")) {
                                            System.out.println(" \u001B[31m Your data will be lost.");
                                            System.out.println(" \u001B[31m Do you want to save it? (y/n)");
                                            Scanner scanner = new Scanner(System.in);
                                            String answer = scanner.nextLine();
                                            if (answer.equals("y")) {
                                                SaveCommand saveCommand = new SaveCommand(getCollection(), new File("collection.json"));
                                                saveCommand.execute();
                                                x.execute();
                                                last_commands.add(x);
                                                tmpSave();
                                            } else if (answer.equals("n")) {
                                                x.execute();
                                                last_commands.add(x);
                                                tmpSave();
                                            } else {
                                                System.out.println(" \u001B[31m Please, enter y or n.");
                                            }
                                        }
                                    }
                                } else {
                                    x.execute();
                                    last_commands.add(x);
                                    tmpSave();
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
//        SaveCommand saveCommand = new SaveCommand(CollectionManager.getCollection(), new File(Objects.requireNonNull(CollectionManager.getFile()).getName()));
//        saveCommand.execute();
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

        private List<File> FileArray = new ArrayList<>();

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