package src.command;

import src.collection.LabWork;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashSet;

public class InfoCommand extends Commands {
    public InfoCommand(LinkedHashSet <LabWork> collection, File file) {
        super(collection, file);
        this.name = "info";
        this.hasArgument = false;
    }

    private Date DateCreated() {
        return Collections.min(collection, Comparator.comparing(LabWork::getCreationDate)).getCreationDate();
    }

    private Date DateLastModification() {
        return Collections.max(collection, Comparator.comparing(LabWork::getCreationDate)).getCreationDate();
    }

    @Override
    public void execute() {

        System.out.println("\u001b[32m Minimal date of collection : \u001b[37m" + DateCreated());
        System.out.println("\u001b[32m Maimum date of collection : \u001b[37m" + DateLastModification());
        System.out.println("\u001b[32m Size of the collection : \u001b[37m" + collection.size());
        System.out.println("\u001b[32m Data types : \u001b[37m" + collection.getClass());
        System.out.println("\u001b[32m Hash code : \u001b[37m" + collection.hashCode());
        System.out.println("\u001b[32m IsEmpty? : \u001b[37m" + collection.isEmpty());
        System.out.println();
        System.out.println("\u001b[32m Max element : \u001b[37m" + Collections.max(collection, Comparator.comparing(LabWork::getId)));
        System.out.println("\u001b[32m Min element : \u001b[37m" + Collections.min(collection, Comparator.comparing(LabWork::getId)));
    }

    @Override
    public String getDescription() {
        return " \u001B[32m info : \u001B[37m вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}
