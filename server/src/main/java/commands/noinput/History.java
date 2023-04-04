package commands.noinput;

import logic.Editor;
import logic.InputData;
import logic.OutputData;

public class History extends AbstractNoInputCommand {
    @Override
    public String getName() {
        return "history";
    }

    @Override
    public String getDescription() {
        return "\u001B[31mhistory \u001B[0m- a command to show history of commands usage!";
    }

    @Override
    public OutputData exec(Editor editor, InputData inputData) {
        return new OutputData("Error", "This message shouldn't be here!");
    }
}