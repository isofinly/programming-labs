package src.main;

import src.collection.*;

import src.utils.*;

import java.io.File;
import java.util.logging.Logger;

/**
 * Main class of the program that starts the program
 * and calls the method for reading commands from the file
 * and executing them or executing them from the console
 */
public final class Main {
    public static void main(String... args) {
        try {
            CollectionManager cm = new CollectionManager("input.json");
            CommandReader.ReadCommand(new File(ParserEnv.envParser(".env").get("FILENAME")), cm.getCollection());
        } catch (Exception e) {
            System.out.println("\u001B[31m ACHTUNG EIN FEHLER IST ENTSCHULDIGT, ICH MOCHTE DIESES PROGRAMM NICHT MACHEN");
            Logger.getGlobal().info(e.getMessage());
        }
    }
}
