package commands.element;

import logic.Editor;
import logic.InputData;
import logic.OutputData;
import objects.FabricLabWorks;
import objects.LabWork;

public class RemoveLower extends AbstractElementCommand {
    @Override
    public String getName() {
        return "remove_lower";
    }

    @Override
    public String getDescription() {
        return "\u001B[31mremove_lower \u001B[0m<element> - a command which removes the elements\nwhich are lower than <key> one.";
    }

    @Override
    public OutputData exec(Editor editor, InputData inputData) {
        try {
            FabricLabWorks fabricLabWorks = new FabricLabWorks();
            LabWork labwork = fabricLabWorks.makeLabworkFromInputData(inputData);
            editor.removeAllLowerByLabwork(labwork);
            editor.save();
        } catch (Exception e) {
            e.printStackTrace();
            return new OutputData("Failure", "Some problems with input data.");
        }
        return new OutputData("Success", "Removed.");
    }
}
