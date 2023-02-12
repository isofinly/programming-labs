package src.command;


import com.google.gson.Gson;
import src.collection.LabWork;

import java.io.*;
import java.util.LinkedHashSet;

public class SaveCommand extends CommandsWithArguments <String> {
    public SaveCommand(LinkedHashSet <LabWork> collection, File file) {
        super(collection, file);
        argumentName = "file_name";
        this.name = "save";
        this.hasArgument = true;
    }

    @Override
    public void execute() {
        File savedJsonCollection = new File("new_" + file);
        try (BufferedWriter outputStreamWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(savedJsonCollection)))) {
            Gson gson = new Gson();
            outputStreamWriter.write(gson.toJson(collection));
            System.out.println("\u001B[34m Collection saved to " + savedJsonCollection.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getDescription() {
        return "\u001b[32m save : \u001b[37m сохранить коллекцию в файл";
    }
}