package src.utils;

import src.collection.LabWork;
import src.command.*;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class CommandReader {
    public static void ReadCommand(File file, LinkedHashSet <LabWork> collection) {

        Scanner in = new Scanner(System.in);
        ReadFunction read = new ReadFunction();

        User user = new User(
                file, collection,
                new ShowCommand(collection, file),
                new AddCommand(collection, file),
                new UpdateCommand(collection, file),
                new ClearCommand(collection, file),
                new SaveCommand(collection, file),
                new RemoveCommand(collection, file),
                new HelpCommand(collection, file),
                new MaxByCreationDateCommand(collection, file),
                new GroupCountingByIdCommand(collection, file),
                new FilterGreaterThanPersonalQualitiesMaximumCommand(collection, file),
                new AddIfMaxCommand(collection, file),
                new RemoveLowerCommand(collection, file),
                read.new ExecuteCommand(collection, file),
                new InfoCommand(collection, file)
        );

        read.setCommands(user.getCommands());

        while (true) {
            System.out.println("\u001B[34m Enter command: ");
            try {
                String userInput = String.valueOf(in.nextLine());
                read.read(userInput);
                if (userInput.equals("exit")) {
                    System.out.println("\u001B[34m Bye :)");
                    break;
                }
            } catch (Exception e) {
                System.out.println("\u001B[31m Invalid number format.");
            }
        }
    }
}

