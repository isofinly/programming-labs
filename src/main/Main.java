package src.main;

import src.collection.*;

import src.utils.*;

import java.io.File;

/**
 * Main class of the program that starts the program
 * and calls the method for reading commands from the file
 * and executing them or executing them from the console
 */
public final class Main {
    public static void main(String... args) throws Exception {
        try {
            CollectionManager cm = new CollectionManager(ParserEnv.envParser(".env").get("FILENAME"));
            CommandReader.ReadCommand(new File(ParserEnv.envParser(".env").get("FILENAME")), cm.getCollection());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u001B[31m No file path");
        }
    }
}
