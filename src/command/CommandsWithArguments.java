package src.command;


import src.collection.LabWork;
import src.command.Commands;

import java.io.File;
import java.util.LinkedHashSet;

public abstract class CommandsWithArguments<T> extends Commands {
    protected T argument;

    protected String argumentName;

    public CommandsWithArguments(LinkedHashSet<LabWork> collection, File file) {
        super(collection, file);
    }

    @Override
    public boolean haveArgument() {
        return true;
    }
    
    public void setArgument(T argument) {
        this.argument = argument;
    }

    public T getArgument() {
        return argument;
    }

    public String getArgumentName() {
        return argumentName;
    }

    public void stringToArgument(String s) throws Exception {
        this.setArgument((T) s);
    }
}