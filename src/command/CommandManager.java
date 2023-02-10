package src.command;

import src.collection.CollectionManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandManager {
    private CollectionManager manager;
    private String commandName;
    private String[] finalUserCommand;
    private List <String> countCommand = new ArrayList <>();

    {
        commandName = "";
    }

    /**
     * @param manager collection manager
     */
    public CommandManager(CollectionManager manager) {
        this.manager = manager;
    }


    /**
     * void that reads and calls all commands
     *
     * @throws IOException input and output exceptions
     */
    public void interactiveMod() throws IOException {
        try (Scanner commandReader = new Scanner(System.in)) {
            while (!commandName.equals("exit")) {
                commandName = commandReader.nextLine();
                finalUserCommand = commandName.trim().split(" ", 3);
                try {
                    switch (finalUserCommand[0]) {
                        case "":
                            break;

                        case "help":
                            if (finalUserCommand.length > 2) {
                                System.out.println("\u001B[31m Illegal arguments. Enter help.\u001B[0m");
                                break;
                            }
                            manager.help();
                            break;

                        case "info":
                            if (finalUserCommand.length > 2) {
                                System.out.println("\u001B[31m Illegal arguments. Enter help.\u001B[0m");
                                break;
                            }
                            manager.info();
                            break;

                        case "show":
                            if (finalUserCommand.length > 2) {
                                System.out.println("\u001B[31m Illegal arguments. Enter help.\u001B[0m");
                                break;
                            }
                            manager.show();
                            break;

                        case "add":
                            if (finalUserCommand.length > 2) {
                                System.out.println("\u001B[31m Illegal arguments. Enter help.\u001B[0m");
                                break;
                            }
                            manager.add(commandReader);
                            break;

                        case "update":
                            if (finalUserCommand.length > 2) {
                                System.out.println("\u001B[31m Illegal arguments. Enter help.\u001B[0m");
                                break;
                            }
                            manager.updateId(finalUserCommand[1]);
                            break;

                        case "remove_by_id":
                            if (finalUserCommand.length > 2) {
                                System.out.println("\u001B[31m Illegal arguments. Enter help.\u001B[0m");
                                break;
                            }
                            manager.remove_by_id(finalUserCommand[1]);
                            break;

                        case "clear":
                            if (finalUserCommand.length > 2) {
                                System.out.println("\u001B[31m Illegal arguments. Enter help.\u001B[0m");
                                break;
                            }
                            manager.clear();
                            break;

                        case "save":
                            if (finalUserCommand.length > 2) {
                                System.out.println("\u001B[31m Illegal arguments. Enter help.\u001B[0m");
                                break;
                            }
                            manager.save();
                            break;

//                        case "execute_script":
//                            if (finalUserCommand.length > 2) {
//                                System.out.println("\u001B[31m Illegal arguments. Enter help.\u001B[0m");
//                                break;
//                            }
//                            if (countCommand.contains(finalUserCommand[1])) {
//                                System.out.println("\u001B[31m the script contains a call to the called script, the program may be looped \u001B[0m");
//                                break;
//                            } else {
//                                countCommand.add(finalUserCommand[1]);
//                            }
//                            scriptExecutor scr = new scriptExecutor(manager, finalUserCommand[1], commandReader, countCommand);
//                            scr.execute_script();
//                            countCommand.clear();
//                            break;

                        case "exit":
                            if (finalUserCommand.length > 2) {
                                System.out.println("\u001B[31m Illegal arguments. Enter help.\u001B[0m");
                                break;
                            }
                            manager.exit();
                            break;

//                        case "add_if_max":
//                            if (finalUserCommand.length > 2) {
//                                System.out.println("\u001B[31m Illegal arguments. Enter help.\u001B[0m");
//                                break;
//                            }
//                            manager.add_if_max(commandReader);
//                            break;
//
//                        case "add_if_min":
//                            if (finalUserCommand.length > 2) {
//                                System.out.println("\u001B[31m Illegal arguments. Enter help.\u001B[0m");
//                                break;
//                            }
//                            manager.add_if_min(commandReader);
//                            break;
//
//                        case "remove_lower":
//                            if (finalUserCommand.length > 2) {
//                                System.out.println("\u001B[31m Illegal arguments. Enter help.\u001B[0m");
//                                break;
//                            }
//                            manager.remove_lower(commandReader);
//                            break;
//                        break;

                        case "max_by_creation_date":
                            if (finalUserCommand.length > 2) {
                                System.out.println("\u001B[31m Illegal arguments. Enter help.\u001B[0m");
                                break;
                            }
                            manager.max_by_creation_date();
                            break;

                        case "group_counting_by_id":
                            if (finalUserCommand.length > 2) {
                                System.out.println("\u001B[31m Illegal arguments. Enter help.\u001B[0m");
                                break;
                            }
                            manager.group_counting_by_id();
                            break;

                        case "filter_greater_than_personal_qualities_maximum":
                            if (finalUserCommand.length > 2) {
                                System.out.println("\u001B[31m Illegal arguments. Enter help.\u001B[0m");
                                break;
                            }
                            manager.filter_greater_than_personal_qualities_maximum(finalUserCommand[1]);
                            break;

                        default:
                            System.out.println("\u001B[31m Unidentified command. Type 'help' for help. \u001B[0m");
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("\u001B[31m No argument. \u001B[0m");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
