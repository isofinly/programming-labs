package src.command;

import src.collection.LabWork;

import java.io.File;
import java.util.*;

public class MaxByCreationDateCommand extends Commands {


    public MaxByCreationDateCommand(LinkedHashSet <LabWork> collection, File file) {
        super(collection, file);
        this.name = "max_by_creation_date";
        this.hasArgument = false;
    }


    @Override
    public String getDescription() {
        return "\u001B[34m max_by_creation_date \u001B[0m - \u001b[34;1m вывести любой объект из коллекции, значение поля creationDate которого является максимальным \u001B[0m";
    }

    @Override
    public void execute() {
        System.out.println(Collections.max(collection, Comparator.comparing(LabWork::getCreationDate)));
    }
}
