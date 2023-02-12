package src.command;

import src.collection.LabWork;

import java.io.File;
import java.util.LinkedHashSet;

public abstract class Commands implements Command {
    protected LinkedHashSet <LabWork> collection;
    File file;

    public Commands(LinkedHashSet <LabWork> collection, File file) {
        this.collection = collection;
        this.file = file;
    }

    protected String name;
    protected boolean hasArgument;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String add) {
        this.name = name;
    }

    @Override
    public boolean haveArgument() {
        return false;
    }

    @Override
    public boolean needCommands() {
        return false;
    }

    @Override
    public String toString() {
        return "Command with name " + name;
    }
}
