package commands.noinput;

import logic.Editor;
import logic.InputData;
import logic.OutputData;

public class Save extends AbstractNoInputCommand {
    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "\u001B[31msave \u001B[0m- a command which saves the collection into collection.json. Can be executed only on server side";
    }

    @Override
    public OutputData exec(Editor editor, InputData inputData) {
        editor.save();
        return new OutputData("Success", "Saved into collection file");
    }
}
