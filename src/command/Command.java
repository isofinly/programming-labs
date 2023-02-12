package src.command;


/**
 * Interface for commands that are used in the program
 * Used in command builder with help of
 * @see Commands
 * @see CommandsWithArguments
 */
public interface Command {
    boolean haveArgument();
    String getName();
    void setName(String add);
    String getDescription();
    boolean needCommands();
    default void execute()  {
        System.out.println(" \u001B[31m Unknown command. Type \u001B[0m 'help' \u001B[31m to see the list of available commands.");
    }
}
