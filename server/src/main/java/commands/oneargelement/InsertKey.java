package commands.oneargelement;

import logic.Editor;
import logic.InputData;
import logic.OutputData;
import objects.FabricLabWorks;
import objects.LabWork;

import java.util.NoSuchElementException;

public class InsertKey extends AbstractOneArgElement {
    @Override
    public String getName() {
        return "insert";
    }

    @Override
    public String getDescription() {
        return "\u001B[31minsert \u001B[0m<key> - a command which asks to give element info and inserts it by key.";
    }

    @Override
    public OutputData exec(Editor editor, InputData inputData) {
        try {
            FabricLabWorks fabricLabWorks = new FabricLabWorks();
            LabWork labwork = fabricLabWorks.makeLabworkFromInputData(inputData);
            if (inputData.getCommandArg().equals(null)) {
                System.out.println("something went wrong");
            }
            editor.insert(inputData.getCommandArg(), labwork);
            editor.save();
//            System.out.println(inputData.toString());
        } catch (NoSuchElementException e) {
            return new OutputData("Failure", "Key already in use");
        }
        return new OutputData("Success", "Inserted.");
    }
}
