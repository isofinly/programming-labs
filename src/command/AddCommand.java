package src.command;

import src.collection.LabWork;

import java.io.File;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class AddCommand extends Commands{

    public AddCommand(LinkedHashSet <LabWork> collection, File file) {
        super(collection, file);
        this.name = "add";
        this.hasArgument = false;
    }

    @Override
    public void execute() {
        int id = 1;
        Set<Integer> collection_id = new HashSet<>();
        collection.forEach(x -> collection_id.add(x.getId()));
        while (collection_id.contains(id)) {id++;}
        LabWork labWork = new LabWork(id);
        collection.add(labWork);
        System.out.println(" \u001B[32m The element was added to the collection.");
    }

    @Override
    public boolean haveArgument() {
        return hasArgument;
    }

    @Override
    public String getDescription() {
        return "\u001b[32m add\u001b[34;1m {element} : \u001b[37m добавить новый элемент в коллекцию";
    }
}
