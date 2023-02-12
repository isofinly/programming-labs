package src.command;


import src.collection.LabWork;
import src.command.Commands;

import java.io.File;
import java.util.LinkedHashSet;

public class ShowCommand extends Commands {
    public ShowCommand(LinkedHashSet <LabWork> collection, File file) {
        super(collection, file);
        this.name = "show";
        this.hasArgument = false;
    }

    @Override
    public void execute() {
        if (collection.isEmpty()){
            System.out.println(" \u001B[31m Collection is empty.");
        } else {
            collection.forEach(labWork -> System.out.println(labWork.toString()));
        }
    }
    @Override
    public boolean haveArgument() {
        return hasArgument;
    }

    @Override
    public String getDescription() {
        return "\u001b[32m show : \u001b[37m вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

}