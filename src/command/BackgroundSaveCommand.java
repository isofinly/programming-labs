package src.command;


import com.google.gson.Gson;
import src.collection.CollectionManager;
import src.collection.LabWork;

import java.io.*;
import java.nio.file.Files;
import java.util.LinkedHashSet;
import java.util.Objects;

/**
 * Class for command save
 *
 * @see CommandsWithArguments
 */
public class BackgroundSaveCommand extends Commands {
    public BackgroundSaveCommand(LinkedHashSet <LabWork> collection, File file) {
        super(collection, file);
        this.name = "background_save_command";
        this.hasArgument = false;
    }

    static File tempFile = new File("crashReport.txt");

    @Override
    public void execute() {
        Gson gson = new Gson();
        FileOutputStream writer = null;
        try {
            writer = new FileOutputStream(tempFile);
            writer.write(gson.toJson(collection).getBytes());
            writer.close();
        } catch (IOException e) {
            System.out.println("\u001b[31m FEHLER BEIM SPEICHERN DER DATEI BITTE");
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("\u001b[31m FEHLER BEIM SCHLIESSEN DER DATEI BITTE");
                }
            }
        }
    }
    public static void createCrashFile() {
        if (!tempFile.exists()) {
            Gson gson = new Gson();
            FileOutputStream writer;
            try {
                writer = new FileOutputStream(tempFile);
                writer.write(gson.toJson(CollectionManager.getCollection()).getBytes());
                writer.close();
//                System.out.println("File created @ " + tempFile.getAbsolutePath());
            } catch (IOException e) {
                System.out.println("\u001B[31m Failed to create crash file");
                System.out.println("\u001B[31m " + e.getMessage());
            }
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
    @Override
    public String getDescription() {
        return "\u001b[32m It is not really a command more like a function that saves the collection to a file in case of a crash";
    }
}
