package src.command;

import src.collection.LabWork;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * Class for command update
 * @see CommandsWithArguments
 */
public class UpdateCommand extends CommandsWithArguments<Integer>{

    public UpdateCommand(LinkedHashSet <LabWork> collection, File file) {
        super(collection, file);
        argumentName = "id";
        this.name = "update";
        this.hasArgument = true;

    }

    @Override
    public String getDescription() {
        return "\u001b[32m update id\u001b[34;1m {element} : \u001b[37m обновить значение элемента коллекции, id которого равен заданному";
    }
    @Override
    public boolean haveArgument() {
        return hasArgument;
    }
    @Override
    public void execute() {

           TreeSet<Integer> collection_id = new TreeSet<>();
            collection.forEach(x -> collection_id.add(x.getId()));

            if (collection_id.contains(argument)) {
                LabWork labWork = new LabWork(argument);
                collection.removeIf(x -> x.getId() == argument);
                collection.add(labWork);
                System.out.println(" \u001B[32m The element was updated.");
            } else {
                System.out.println(" \u001B[31m The element with this id does not exist.");
            }
    }
    @Override
    public void stringToArgument(String arg) {
        this.setArgument(Integer.parseInt(arg));
    }
}
