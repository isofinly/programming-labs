package commands.onearg;

import logic.Editor;
import logic.InputData;
import logic.OutputData;

public class ExecuteScript extends AbstractOneArgCommand {
    @Override
    public String getName() {
        return "execute_script";
    }

    @Override
    public String getDescription() {
        return "\u001B[31mexecute_script \u001B[0m<filename> - a command which executes a script.";
    }

    @Override
    public OutputData exec(Editor editor, InputData inputData) {
        Poop poop = new Poop();
        poop.run(editor, inputData);
        return new OutputData("ExecuteScript result:", poop.cachedResults.toString());
    }
}
