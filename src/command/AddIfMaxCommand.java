package src.command;

import src.collection.LabWork;

import java.io.File;

import java.util.LinkedHashSet;

import java.util.Set;

import java.util.TreeSet;

/**
 * Class responsible for adding a new element to the collection
 * if its value exceeds the value of the largest element of this collection
 * @see Commands
 */
public class AddIfMaxCommand extends Commands {
    public AddIfMaxCommand(LinkedHashSet <LabWork> collection, File file) {
        super(collection, file);
        this.name = "add_if_max";
        this.hasArgument = false;
    }

    @Override
    public void execute() {
        int id = 1;
        Set <Integer> collectionIds = new TreeSet <>();
        collection.forEach(labWork -> collectionIds.add(labWork.getId()));
        while (collectionIds.contains(id)) {
            id++;
        }
        LabWork labWork = new LabWork(id);
        if (!collection.contains(labWork) && labWork.compareTo(collection.stream().max(LabWork::compareTo).orElse(labWork)) > 0) {
            collection.add(labWork);
            System.out.println(" \u001B[32m The element was added to the collection.");
        } else {
            System.err.println(" The element was not added to the collection.");
        }
    }

    @Override
    public String getDescription() {
        return "\u001B[34m add_if_max \u001B[0m - \u001b[34;1m добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции \u001B[0m";
    }
}
