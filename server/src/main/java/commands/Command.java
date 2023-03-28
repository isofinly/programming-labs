package commands;

import logic.Editor;
import logic.InputData;
import logic.OutputData;

public interface Command {
    String getName();
    String getDescription();
    OutputData exec(Editor editor, InputData inputData);
    CommandType[] getCommandType();
}
