package src.command;

import src.collection.LabWork;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.*;
import java.util.regex.Pattern;


/**
 * Class for reading commands from input s
 * Uses regex
 * see @CommandsWithArguments
 */
public class ReadFunction {

    Commands[] commands;
    Deque <Commands> last_commands = new LinkedList <>();

    public void setCommands(Commands[] commands) {
        this.commands = commands;
    }


    // TODO 1: change for loop to stream API
    public void read(String s) {
        boolean flag = false;

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
                                last_commands.add(command_arg);
                                flag = true;
                            } catch (Exception e) {
                                System.out.println("\u001B[01m Congrats, you found a bug. Please, contact the developer." +
                                        " \n \u001B[31m Error message: " + e.getMessage());
                            }
                        } else {
                            x.execute();
                            last_commands.add(x);
                            flag = true;
                        }
                    } catch (Exception e) {
                        System.out.println("\u001B[31m " + e.getMessage());
                    }
                }
            }
        } if (!flag) {
                System.out.println("\u001B[31m BITTE GEBEN SIE DEN RICHTIGEN BEFEHL EIN. ICH BIN ZU EINFACH, UM GEDANKEN ZU LESEN.");
                System.out.println("\u001B[32m help : \u001B[0m show all commands");
            }
    }

@Deprecated
public class HistoryCommand extends Commands {
        public HistoryCommand(LinkedHashSet <LabWork> labWorks, File file) {
            super(labWorks, file);
        }

        @Override
        public void execute() {
            if (ReadFunction.this.last_commands.size() < 9) {
                last_commands.forEach(System.out::println);
                if (ReadFunction.this.last_commands.size() == 0) {
                    System.out.println("Команд нет.");
                }

            } else {
                int i = 0;
                for (Commands x : last_commands) {
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