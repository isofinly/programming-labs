package commands.noinput;

import logic.Editor;
import logic.InputData;
import logic.OutputData;

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
        editor.clear();
        editor.save();
        return new OutputData("Success", "Successfully cleared the collection.");
    }
}
