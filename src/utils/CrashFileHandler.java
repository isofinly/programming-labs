package src.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;


/**
 * Class for handling crash exiting of the program
 */
public class CrashFileHandler {
    static File tempFile = new File("crashReport.txt");

    public static void createCrashFile() {
        if (!tempFile.exists()) {
            try {
                FileOutputStream writer = new FileOutputStream(tempFile);
                writer.close();
//                System.out.println("File created @ " + tempFile.getAbsolutePath());
            } catch (IOException e) {
                System.out.println("\u001B[31m Failed to create crash file");
                System.out.println("\u001B[31m " + e.getMessage());
            }
        } else {
            System.out.println("\u001B[31m Previos session was not exited properly.");
        }
    }

    public static void deleteCrashFile() {
        try {
            Files.deleteIfExists(tempFile.toPath());
        } catch (IOException e) {
            System.out.println("\u001B[31m FEHLER BEIM LÖSCHEN DER DATEI BITTE KONTAKTIEREN SIE DEN PROGRAMMAUTOR");
            System.out.println("\u001B[31m" + e);
        }

    }

}