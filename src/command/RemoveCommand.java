package src.command;

import src.collection.LabWork;

import java.io.File;
import java.util.LinkedHashSet;

/**
 * Class for command remove
 * Integer as an argument
 * @see CommandsWithArguments
 */
public class RemoveCommand extends CommandsWithArguments<Integer>{
    public RemoveCommand(LinkedHashSet <LabWork> collection, File file) {
        super(collection, file);
        this.name = "remove";
        this.hasArgument = true;
        this.argumentName = "id";
    }

    @Override
    public void execute() {
        boolean flag = false;
        for (LabWork works : collection) {
            int argument = Integer.parseInt(String.valueOf(this.argument));
            if (works.getId() == argument) {
                collection.remove(works);
                System.out.println(" \u001B[32m The element was removed from the collection.");
                flag = true;
                break;
            }
        } if (!flag) {
            throw new IllegalArgumentException(" \u001B[31m The element with this id is not in the collection.");
        }
    }

    @Override
    public String getDescription() {
        return "\u001b[32m remove_by_id\u001b[34;1m id : \u001b[37m удалить элемент из коллекции по его id";
    }
}
