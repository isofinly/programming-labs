package src.command;

import src.collection.LabWork;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Class for command remove_lower
 * @see Commands
 */
public class RemoveLowerCommand extends Commands {
    public RemoveLowerCommand(LinkedHashSet <LabWork> collection, File file) {
        super(collection, file);
        this.name = "remove_lower";
        this.hasArgument = false;
    }

    @Override
    public String getDescription() {
        return "\u001B[34m remove_lower \u001B[0m - \u001b[34;1m удалить из коллекции все элементы, меньшие, чем заданный \u001B[0m";
    }

    @Override
    public void execute() {
        LabWork labWork = new LabWork();
        LinkedHashSet<LabWork> labWorks = new LinkedHashSet<>(collection);
        Optional<LabWork> max = collection.stream().filter(x -> x.compareTo(labWork) < 0).max(LabWork::compareTo);
        if (max.isPresent()) {
            Set<LabWork> collect = collection.stream().filter(x -> x.compareTo(max.get()) <= 0).collect(Collectors.toSet());
            labWorks.removeAll(collect);
            collection.removeAll(labWorks);
        }
        System.out.println(" \u001B[32m Elements were removed.");
    }

}