package src.command;

import src.collection.LabWork;

import java.io.File;
import java.util.LinkedHashSet;

public class FilterGreaterThanPersonalQualitiesMaximumCommand extends CommandsWithArguments<Integer>{
    public FilterGreaterThanPersonalQualitiesMaximumCommand(LinkedHashSet <LabWork> collection, File file) {
        super(collection, file);
        this.name = "filter_greater_than_personal_qualities_maximum";
        this.hasArgument = true;
    }

    @Override
    public String getDescription() {
        return "\u001b[32m filter_greater_than_personal_qualities_maximum : \u001b[37m вывести элементы, значение поля personalQualities которых больше заданного";
    }

    @Override
    public void execute() {
        int argument = Integer.parseInt(String.valueOf(this.argument));
        if (collection.isEmpty()){
            System.out.println(" \u001B[31m Collection is empty.");
        } else {
            collection.stream().filter(labWork -> labWork.getPersonalQualitiesMaximum() > argument).forEach(System.out::println);
        }
    }
}
