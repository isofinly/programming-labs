package src.command;

/**
 * Интерфейс команд
 * @version 1.0
 * @see Commands
 */
public interface Command {
     /**
      *
      * @return String with Russian description
      */
      String ru_description();

      /**
       * Checking for Arguments
       * @return <b>true</b> if there is an argument
       */
      boolean HaveArgument();
 
      /**
       *
       * @return Command name
       */
      String getName();
 
      /**
       * Set name
       * @param name Command name
       */
      void setName(String name);
 
      /**
       * Check for the need for an array of commands
       * @return <b>true</b> if you need an array of commands
       */
      boolean NeedCommands();

    /**
     * default method to execute command
     */
    default void execute() {
        System.out.println("Unknown command. Type 'help' to see the list of available commands.");
    }
}
