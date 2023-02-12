package src.command;


import src.collection.LabWork;
import src.command.Commands;

import java.io.File;
import java.util.LinkedHashSet;

public class ClearCommand extends Commands {
    public ClearCommand(LinkedHashSet <LabWork> collection, File file) {
        super(collection, file);
        this.name = "clear";
        this.hasArgument = false;
    }

    @Override
    public void execute()  {
        collection.clear();
        System.out.println(" \u001B[32m Collection was cleared.");
    }
    @Override
    public boolean haveArgument() {
        return hasArgument;
    }

    @Override
    public String getDescription() {
        return "\u001b[32m clear : \u001b[37m очистить коллекци";
    }
}