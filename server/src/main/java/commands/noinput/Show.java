package commands.noinput;

import commands.noinput.AbstractNoInputCommand;
import logic.Editor;
import logic.InputData;
import logic.OutputData;

public class Show extends AbstractNoInputCommand {
    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return "\u001B[31mshow \u001B[0m- a command which shows the collection items";
    }

    @Override
    public OutputData exec(Editor editor, InputData inputData) {
        System.out.println(inputData.toString());
        return new OutputData("Success", editor.getNiceLookingString());
    }
}
