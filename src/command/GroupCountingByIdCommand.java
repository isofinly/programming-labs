package src.command;

import src.collection.LabWork;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class GroupCountingByIdCommand extends Commands{
    public GroupCountingByIdCommand(LinkedHashSet <LabWork> collection, File file) {
        super(collection, file);
        this.name = "group_counting_by_id";
        this.hasArgument = false;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void execute() {
        TreeMap <Integer, Long> groupCollectionByIdRemainder = new TreeMap(collection.stream().collect(Collectors.groupingBy(LabWork::getIdRemainder, Collectors.counting())));
        System.out.println("\u001B[32m Collection grouped by id % 5: \u001B[0m" + groupCollectionByIdRemainder);
    }
}
