package src.command;


import com.google.gson.Gson;
import src.collection.LabWork;

import java.io.*;
import java.util.LinkedHashSet;

/**
 * Class for command save
 *
 * @see CommandsWithArguments
 */
public class BackgroundSaveCommand extends CommandsWithArguments<String> {
    public BackgroundSaveCommand(LinkedHashSet<LabWork> collection, File file) {
        super(collection, file);
        argumentName = "file_name";
        this.name = "background_save_command";
        this.hasArgument = false;
    }

    @Override
    public void execute() {
        Gson gson = new Gson();
        File tempFile = null;
        BufferedWriter writer = null;
        File savedJsonCollection = new File("new_" + file);

        try {
            // Creating a temporary file
            tempFile = File.createTempFile("collection", ".tmp");
            writer = new BufferedWriter(new FileWriter(tempFile));
            writer.write(gson.toJson(collection));
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

        try (BufferedWriter outputStreamWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(savedJsonCollection)))) {
            BufferedReader reader = new BufferedReader(new FileReader(tempFile));
            String line;
            while ((line = reader.readLine()) != null) {
                outputStreamWriter.write(line);
            }
        } catch (IOException e) {
            System.out.println("\u001b[31mFEHLER BEIM SPEICHERN DER DATEI BITTE");
        }
    }

    @Override
    public String getDescription() {
        return "\u001b[32m background_save_command : \u001b[37m сохранение бэкапа коллекции в файл";
    }
}