package src.main;

import src.collection.*;

import src.utils.*;

import java.io.File;
import java.util.logging.Logger;


// TODO restore last session
/**
 * Main class of the program that starts the program
 * and calls the method for reading commands from the file
 * and executing them or executing them from the console
 */
public final class Main {
    public static void main(String... args) {
        String path =
        System.getenv().getOrDefault("LABFILEPATH", "input.json");
        try {
            new CollectionManager(path);
            CommandReader.ReadCommand(new File(path), CollectionManager.getCollection());
        } catch (Exception e) {
            System.out.println("\u001B[31m ACHTUNG EIN FEHLER IST ENTSCHULDIGT, ICH MOCHTE DIESES PROGRAMM NICHT MACHEN");
            Logger.getGlobal().info(e.getMessage());
        }
    }
}
