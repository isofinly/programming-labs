package src.command;

import src.collection.LabWork;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class ExitCommand extends Commands {
    public ExitCommand(LinkedHashSet<LabWork> collection, File file) {
        super(collection, file);
        this.name = "exit";
        this.hasArgument = false;
    }

    @Override
    public String getDescription() {
        return "\u001b[32m exit : \u001b[37m завершить программу (без сохранения в файл)";
    }

    @Override
    public void execute() {
        System.out.println("\u001B[32m Bye :)");
        System.exit(0);
    }
}
