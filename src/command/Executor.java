package src.command;

import src.collection.CollectionManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Executor {
    private CollectionManager manager;
    private File scriptPath;
    private Scanner commandReader;
    private String[] finalUserCommand;
    private List <String> counter;


    public Executor(CollectionManager manager, String path, Scanner commandReader, List <String> counter) {
        this.manager = manager;
        this.scriptPath = new File(path);
        this.commandReader = commandReader;
        this.counter = counter;
    }

    public void executionStart() throws IOException {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(scriptPath)))) {
            String line;
            if (!scriptPath.canRead() || !scriptPath.exists() || scriptPath.isDirectory() || scriptPath.isHidden() || !scriptPath.canRead())
                throw new SecurityException("\u001B[31m You're trying to fool me executing some weird file.\u001B[0m");
            while ((line = buffer.readLine()) != null) {
                finalUserCommand = line.trim().split(" ", 3);
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
                            List <String> args = new ArrayList <>();
                            while (args.size() != 9) {
                                args.add(commandReader.nextLine());
                            }
                            manager.add(args);
                            break;

                        case "update":
                            if (finalUserCommand.length > 3) {
                                System.out.println("\u001B[31m Illegal arguments. Enter help.\u001B[0m");
                                break;
                            }
                            manager.updateId(finalUserCommand[1]);
                            break;

                        case "remove_by_id":
                            if (finalUserCommand.length > 3) {
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

                        case "exit":
                            if (finalUserCommand.length > 2) {
                                System.out.println("\u001B[31m Illegal arguments. Enter help.\u001B[0m");
                                break;
                            }
                            manager.exit();
                            break;

                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("\u001B[31m No arguments given.\u001B[0m");
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("\u001B[31m File not found. Yikes! \u001B[0m");
        }

    }
}

