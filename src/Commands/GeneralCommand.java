package src.Commands;

import java.io.File;
import java.util.LinkedHashSet;

import src.CollectionClasses.LabWork;
/**
 * Адстрактный класс для команд
 * @version 1.0
 */

public abstract class GeneralCommand implements Command{
    /**
     * Массив элементов
     */
    protected LinkedHashSet<LabWork> labWork;
    /**
     * Файл для записи
     */
    File file;

    /**
     * Конструктор для задания команды.
     * @param routes Коллекция элементов
     * @param file Файл
     */
    public void Commands( LinkedHashSet<LabWork> labWork, File file){
        this.labWork=labWork;
        this.file=file;
    }

    /**
     * Имя команды
     */
    protected String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public boolean HaveArgument(){
        return false;
    }

    @Override
    public boolean NeedCommands() {
        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}
