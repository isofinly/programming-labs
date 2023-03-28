package commands.noinput;

import logic.Editor;
import logic.InputData;
import logic.OutputData;

public class PrintDescendingDifficulty extends AbstractNoInputCommand {
    @Override
    public String getName() {
        return "print_field_descending_difficulty";
    }

    @Override
    public String getDescription() {
        return "\u001B[31mprint_field_descending_difficulty \u001B[0m- a command which prints descending difficulty.";
    }

    @Override
    public OutputData exec(Editor editor, InputData inputData) {
        return new OutputData("Success", editor.getDescendingDifficulty());
    }
}
