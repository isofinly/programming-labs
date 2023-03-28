package commands.noinput;

import commands.noinput.AbstractNoInputCommand;
import logic.Editor;
import logic.InputData;
import logic.OutputData;

public class Exit extends AbstractNoInputCommand {
    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "\u001B[31mexit \u001B[0m- a command to exit everything.";
    }

    @Override
    public OutputData exec(Editor editor, InputData inputData) {
        System.exit(0);
        return new OutputData("Exited", "just exit by clicking!");
    }
}
