package src.command;

import src.collection.LabWork;

import java.io.File;

import java.util.LinkedHashSet;

/**
 * Class for command "help"
 * @see CommandsUseArray
 */
public class HelpCommand extends Commands {
    public HelpCommand(LinkedHashSet <LabWork> labWorks, File file) {
        super(labWorks, file);
        this.name = "help";
        this.hasArgument = false;
    }


    @Override
    public void execute() {

        System.out.println("\u001b[32m help : \u001b[37;1m вывести справку по доступным командам");
        System.out.println("\u001b[32m info : \u001b[37;1m вывести в стандартный поток вывода информацию о коллекции");
        System.out.println("\u001b[32m show : \u001b[37;1m вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        System.out.println("\u001b[32m add\u001b[34;1m {element} : \u001b[37;1m добавить новый элемент в коллекцию");
        System.out.println("\u001b[32m update id\u001b[34;1m {element} : \u001b[37m обновить значение элемента коллекции, id которого равен заданному");
        System.out.println("\u001b[32m remove_by_id\u001b[34;1m id : \u001b[37m удалить элемент из коллекции по его id");
        System.out.println("\u001b[32m clear : \u001b[37m очистить коллекцию");
        System.out.println("\u001b[32m save : \u001b[37m сохранить коллекцию в файл");
        System.out.println("\u001b[32m execute_script\u001b[34;1m file_name : \u001b[37m считать и исполнить скрипт из указанного файла. Рекурсивные вызовы скриптов запрещены");
        System.out.println("\u001b[32m exit : \u001b[37m завершить программу (без сохранения в файл)");
        System.out.println("\u001b[32m add_if_max\u001b[34;1m {element} : \u001b[37m добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
        System.out.println("\u001b[32m remove_lower\u001b[34;1m {element} : \u001b[37m удалить из коллекции все элементы, превышающие заданный");
        System.out.println("\u001b[32m max_by_creation_date : \u001b[37m вывести любой объект из коллекции, значение поля creationDate которого является максимальным");
        System.out.println("\u001b[32m group_counting_by_id : \u001b[37m сгруппировать элементы коллекции по значению поля id, вывести количество элементов в каждой группе");
        System.out.println("\u001b[32m filter_greater_than_personal_qualities_maximum\u001b[34;1m personalQualitiesMaximum : \u001b[37m вывести элементы, значение поля personalQualitiesMaximum которых больше заданного");

    }

    @Override
    public String getDescription() {
        return "\u001b[32m help \u001B[0m - \u001b[34;1m вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
