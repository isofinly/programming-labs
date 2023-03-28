package commands.noinput;

import commands.noinput.AbstractNoInputCommand;
import logic.Editor;
import logic.InputData;
import logic.OutputData;

import java.sql.SQLException;

public class Clear extends AbstractNoInputCommand {
    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescription() {
        return "\u001B[31mclear \u001B[0m- a command to clear the collection.";
    }

    @Override
    public OutputData exec(Editor editor, InputData inputData) {
//        editor.getCollection().clear();
//        System.out.println(editor.getCollection());
        editor.clear();
        editor.save();
//        System.out.println(inputData.toString());
//        System.out.println(editor.getCollection());
        return new OutputData("Success", "Successfully cleared the collection.");
    }
}
