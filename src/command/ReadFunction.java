package src.command;

import jdk.jfr.Unsigned;
import src.collection.LabWork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;


/**
 * Class for reading commands from input s
 * Uses regex
 * see @CommandsWithArguments
 */
public class ReadFunction {

    Commands[] commands;
    Deque <Commands> Last_comands = new LinkedList <>();

    public void setCommands(Commands[] commands) {
        this.commands = commands;
    }

    public void read(String s) {

        for (Commands x : commands) {
            String[] S = s.split(" ");

            if (x.getName().equals(S[0].trim())) {
                Pattern pattern = Pattern.compile(x.getName());

                if (pattern.matcher(x.getName()).matches()) {
                    try {
                        if (x.haveArgument()) {
                            try {
                                CommandsWithArguments <?> command_arg = (CommandsWithArguments <?>) x;
                                command_arg.stringToArgument(S[S.length - 1].trim());
                                command_arg.execute();
                                Last_comands.add(command_arg);
                            } catch (Exception e) {
                                System.out.println("\u001B[01m Congrats, you found a bug. Please, contact the developer." +
                                        " \n \u001B[31m Error message: " + e.getMessage());
                            }
                        } else {
                            x.execute();
                            Last_comands.add(x);
                        }
                    } catch (Exception e) {
                        System.out.println("\u001B[31m " + e.getMessage());
                    }
                }
            }
        }
    }

@Deprecated
public class HistoryCommand extends Commands {
        public HistoryCommand(LinkedHashSet <LabWork> labWorks, File file) {
            super(labWorks, file);
        }

        @Override
        public void execute() {
            if (ReadFunction.this.Last_comands.size() < 9) {
                Last_comands.forEach(x -> System.out.println(x));
                if (ReadFunction.this.Last_comands.size() == 0) {
                    System.out.println("Команд нет.");
                }

            } else {
                int i = 0;
                for (Commands x : Last_comands) {
                    i++;
                    System.out.println(x);
                    if (i == 9) {
                        break;
                    }
                }
            }
        }

        @Override
        public String getDescription() {
            return "\u001B[32m history :\u001B[0m show last 9 commands";
        }

    }

    /**
     * Class for command execution that converts string to argument
     * @see CommandsWithArguments
     */
    public class ExecuteCommand extends CommandsWithArguments <String> {

        public ExecuteCommand(LinkedHashSet <LabWork> labWorks, File file) {
            super(labWorks, file);
            argumentName = "file_name";
            this.name = "execute_script";
            this.hasArgument = true;
        }

        private List <File> FileArray = new ArrayList <>();

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
                } catch (FileNotFoundException e) {
                    System.out.println("\u001B[31m File not found");
                }
                FileArray.remove(script);
            }
        }

        @Override
        public String getDescription() {
            return "\u001B[32m execute_script file_name :\u001B[0m считать и исполнить скрипт из указанного файла.";
        }

    }
}