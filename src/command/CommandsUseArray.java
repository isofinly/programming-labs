package src.command;

import src.collection.LabWork;

import java.io.File;
import java.util.LinkedHashSet;

/**
 * Abstract class for commands with array of commands
 * @see Command
 * Do not confuse with Commands
 * @see Commands
 */

@Deprecated
public abstract class CommandsUseArray extends Commands{
    protected Commands[] commands;
    public CommandsUseArray(LinkedHashSet<LabWork> collection, File file){
        super(collection, file);
    }
    @Override
    public boolean needCommands() {
        return true;
    }
    public void setCommands(Commands[] commands) {
        this.commands = commands;
    }

    public Commands[] getCommands() {
        return commands;
    }
}
