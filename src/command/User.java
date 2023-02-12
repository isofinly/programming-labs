package src.command;


import src.collection.LabWork;

import java.io.File;
import java.util.LinkedHashSet;

/**
 * class that execute commands
 * main interaction with commands is done by Reader
 * @see ReadFunction
 * @see Commands
 * @see CommandsWithArguments
 */
public class User {
    @Deprecated
    private static void help_print_for_command(Commands Commands) {
        System.out.println(Commands.getName() + (Commands.haveArgument() ? " " + ((CommandsWithArguments <?>) Commands).getArgumentName() + " " : "") + " - " + Commands.getDescription());
    }

    private Commands add;
    private Commands show;
    private Commands clear;
    private Commands save;
    private Commands update;
    private Commands remove;
    private Commands help;
    private Commands max_by_creation_date;
    private Commands group_counting_by_id;
    private Commands filter_greater_than_personal_qualities_maximum;
    private Commands add_if_max;
    private Commands remove_lower;
    private Commands execute;
    private Commands info;
    private Commands[] commands;

    public User(File file, LinkedHashSet <LabWork> labWorks,
                Commands show, Commands add, Commands update,
                Commands clear, Commands save, Commands remove,
                Commands help, Commands max_by_creation_date, Commands group_counting_by_id,
                Commands filter_greater_than_personal_qualities_maximum, Commands add_if_max,
                Commands remove_lower, Commands execute_script, Commands info ){
        this.info = info;
        this.info.setName("info");
        this.execute = execute_script;
        this.execute.setName("execute_script");
        this.remove_lower = remove_lower;
        this.remove_lower.setName("remove_lower");
        this.add_if_max = add_if_max;
        this.add_if_max.setName("add_if_max");
        this.filter_greater_than_personal_qualities_maximum = filter_greater_than_personal_qualities_maximum;
        this.filter_greater_than_personal_qualities_maximum.setName("filter_greater_than_personal_qualities_maximum");
        this.group_counting_by_id = group_counting_by_id;
        this.group_counting_by_id.setName("group_counting_by_id");
        this.max_by_creation_date = max_by_creation_date;
        this.max_by_creation_date.setName("max_by_creation_date");
        this.help = help;
        this.help.setName("help");
        this.remove = remove;
        this.remove.setName("remove");
        this.add = add;
        this.add.setName("add");
        this.show = show;
        this.show.setName("show");
        this.clear = clear;
        this.clear.setName("clear");
        this.save = save;
        this.save.setName("save");
        this.update = update;
        this.update.setName("update");
        this.commands = new Commands[]{
                this.add, this.show, this.clear,
                this.save, this.update, this.remove,
                this.help, this.max_by_creation_date, this.group_counting_by_id,
                this.filter_greater_than_personal_qualities_maximum, this.add_if_max, this.remove_lower,
                this.execute, this.info
        };
    }

    public void add() {
        add.execute();
    }
    public void show() {
        show.execute();
    }
    public void clear() {
        clear.execute();
    }
    public void save() {
        save.execute();
    }
    public void update() {
        update.execute();
    }
    public void remove() {
        remove.execute();
    }
    public void help() {
        help.execute();
    }
    public void max_by_creation_date() {
        max_by_creation_date.execute();
    }
    public void filter_greater_than_personal_qualities_maximum() {
        filter_greater_than_personal_qualities_maximum.execute();
    }
    public void add_if_max() {
        add_if_max.execute();
    }
    public void remove_lower() {
        remove_lower.execute();
    }
    public void execute_script() {
        execute.execute();
    }
    public void info() {
        info.execute();
    }

    public Commands[] getCommands() {
        return this.commands;
    }
}
