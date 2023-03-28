package commands.noinput;

import logic.Editor;
import logic.InputData;
import logic.OutputData;

public class AverageMinimalPoint extends AbstractNoInputCommand {
    @Override
    public String getName() {
        return "average_of_minimal_point";
    }

    @Override
    public String getDescription() {
        return "\u001B[31maverage_of_minimal_point \u001B[0m- a command which show an average\n minimal point field value of collection items.";
    }

    @Override
    public OutputData exec(Editor editor, InputData inputData) {
        return new OutputData("Success", editor.getAverageMinimalPoint());
    }
}
