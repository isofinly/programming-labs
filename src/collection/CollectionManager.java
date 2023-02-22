package src.collection;

import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jetbrains.annotations.Nullable;
import src.command.BackgroundSaveCommand;


import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import java.util.regex.Pattern;



/*
 * help : вывести справку по доступным командам
 * info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
 * show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
 * add {element} : добавить новый элемент в коллекцию
 * update id {element} : обновить значение элемента коллекции, id которого равен заданному
 * remove_by_id id : удалить элемент из коллекции по его id
 * clear : очистить коллекцию
 * save : сохранить коллекцию в файл
 * execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
 * exit : завершить программу (без сохранения в файл)
 * add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции
 * add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
 * remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный
 * max_by_creation_date : вывести любой объект из коллекции, значение поля creationDate которого является максимальным
 * group_counting_by_id : сгруппировать элементы коллекции по значению поля id, вывести количество элементов в каждой группе
 * filter_greater_than_personal_qualities_maximum personalQualitiesMaximum : вывести элементы, значение поля personalQualitiesMaximum которых больше заданного
 */


/**
 * Class for managing the collection and its elements
 *
 * @see LabWork
 * @see LinkedHashSet
 */
public class CollectionManager {

    protected static LinkedHashSet<LabWork> labWork;
    protected File jsonCollection;
    protected Date initDate;
    private File outPut;

    Gson gson = new Gson();
    @Deprecated
    protected static HashMap<String, String> manual;
    @Deprecated
    private final List<String> scriptStack = new ArrayList<>();

    {
        Gson gson = new Gson();
        labWork = new LinkedHashSet<>();
        manual = new HashMap<>();

        manual.put("\u001B[32m help: \u001B[0m", "output help for available commands");
        manual.put("\u001B[32m info: \u001B[0m", "output information about the collection (type, initialization date, number of items, etc.) to the standard output stream.");
        manual.put("\u001B[32m show: \u001B[0m", "output to the standard output stream all the elements of the collection in a string representation");
        manual.put("\u001B[32m add {element}: \u001B[0m", "add a new item to the collection");
        manual.put("\u001B[32m update id {element}: \u001B[0m", "update the value of a collection item whose id is equal to the specified one");
        manual.put("\u001B[32m remove_by_id id: \u001B[0m", "delete an item from the collection by its id");
        manual.put("\u001B[32m clear: \u001B[0m", "clear the collection");
        manual.put("\u001B[32m save: \u001B[0m", "save the collection to a file");
        manual.put("\u001B[32m execute_script file_name: \u001B[0m", "read and execute the script from the specified file.");
        manual.put("\u001B[32m exit: \u001B[0m", "terminate the program (without saving to a file)");
        manual.put("\u001B[32m add_if_max {element}: \u001B[0m", "add a new item to the collection if its value is greater than that of the largest item in this collection");
        manual.put("\u001B[32m add_if_min {element}: \u001B[0m", "add a new item to the collection if its value is less than that of the smallest item in this collection");
        manual.put("\u001B[32m remove_lower {element}: \u001B[0m", "remove all items smaller than the specified one from the collection");
        manual.put("\u001B[32m max_by_creation_date: \u001B[0m", "output any object from the collection, the value of the creationDate field of which is the maximum");
        manual.put("\u001B[32m group_counting_by_area: \u001B[0m", "group the elements of the collection by the value of the area field, output the number of elements in each group");
        manual.put("\u001B[32m filter_greater_than_personal_qualities_maximum: \u001B[0m", "output elements whose value of the personalQualitiesMaximum field is greater than the specified one");
    }


    public CollectionManager(String inPath) {
        File tempFile = new File("crashReport.txt");
        if (tempFile.exists()){
            System.out.println("\u001B[31m Previos session was not exited properly. \n Do you want to restore it? (y/n)");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (answer.equals("y")){
                System.out.println("\u001B[32m Loading previos session.");
                inPath = "crashReport.txt";
            } else {
                System.out.println("\u001B[32m Starting new session.");
            }
        }
        this.jsonCollection = new File(inPath);
        this.initDate = new Date();
        this.load();
        BackgroundSaveCommand.createCrashFile();
    }



    public static File getFile() {
        try {
            return File.createTempFile("collectionBackup", ".json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void load() {
        ObjectMapper objectMapper = new ObjectMapper();
        int fileSize = labWork.size();

        if (!jsonCollection.exists()) {
            System.out.println("\u001B[31m File not found.");
            System.exit(1);
        }

        if (!jsonCollection.canRead() || !jsonCollection.canWrite()) {
            System.out.println("\u001B[31m No access to file. Check file permissions.");
            System.exit(1);
        }

        if (jsonCollection.length() == 0) {
            System.out.println("\u001B[31m File is empty.");
            System.exit(1);
        }
        try (BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(new FileInputStream(jsonCollection)))) {
            System.out.println("\u001B[34m Collection is loading " + jsonCollection.getAbsolutePath());
            String nextLine;
            StringBuilder result = new StringBuilder();
            while ((nextLine = inputStreamReader.readLine()) != null) {
                result.append(nextLine);
            }
            Type collectionTypeObject = new TypeToken<LinkedHashSet<Object>>() {
            }.getType();
            LinkedHashSet<Object> itemsObj = gson.fromJson(result.toString(), collectionTypeObject);
            while (itemsObj.iterator().hasNext()) {
                Map<String, Object> map = objectMapper.convertValue(itemsObj.iterator().next(), new TypeReference<>() {
                });
//                System.out.println(itemsObj.iterator().next());
                try {
                    if (map.size() == 7) {
                        labWork.add(new LabWork((String) getMapValue(map, "name"),
                                new Coordinates(
                                        (Double) getMapValue(map, "coordinates.x"),
                                        Float.parseFloat(getMapValue(map, "coordinates.y").toString())
                                ),
                                (int) Double.parseDouble(getMapValue(map, "minimalPoint").toString()),
                                (int) Double.parseDouble(getMapValue(map, "personalQualitiesMinimum").toString()),
                                (long) Double.parseDouble(getMapValue(map, "personalQualitiesMaximum").toString()),
                                Difficulty.valueOf((String) getMapValue(map, "difficulty")),
                                new Discipline(
                                        (String) getMapValue(map, "discipline.name"),
                                        (long) Double.parseDouble(getMapValue(map, "discipline.practiceHours").toString())
                                )
                        ));
                    } else if (map.size() == 9) {
                        labWork.add(new LabWork(
                                (int) Double.parseDouble(getMapValue(map, "id").toString()),
                                (String) getMapValue(map, "name"),
                                new Coordinates(
                                        Double.parseDouble(getMapValue(map, "coordinates.x").toString()),
                                        Float.parseFloat(getMapValue(map, "coordinates.y").toString())
                                ),
                                (String) getMapValue(map, "creationDate"),
                                (int) Double.parseDouble(getMapValue(map, "minimalPoint").toString()),
                                (int) Double.parseDouble(getMapValue(map, "personalQualitiesMinimum").toString()),
                                (long) Double.parseDouble(getMapValue(map, "personalQualitiesMaximum").toString()),
                                Difficulty.valueOf((String) getMapValue(map, "difficulty")),
                                new Discipline(
                                        (String) getMapValue(map, "discipline.name"),
                                        (long) Double.parseDouble(getMapValue(map, "discipline.practiceHours").toString())
                                )
                        ));
                    } else {
                        System.out.println("\u001B[31m Invalid collection file format.");
                        System.exit(1);
                    }
                    itemsObj.remove(itemsObj.iterator().next());
                } catch (NullPointerException ex) {
                    System.out.println("\u001B[31m Null pointer, my friendo.");
                    System.exit(1);
                }
            }
            System.out.println("\u001B[34m Collection of type \u001B[0m" + labWork.getClass().getName() + "\u001B[34m successfully loaded in size of \u001B[0m" + (labWork.size() - fileSize) + "\u001B[34m elements.");
        } catch (IOException e) {
            System.out.println("\u001B[31m IO error while operating file.");
            System.exit(1);
        }
    }

    public static Object getMapValue(Map<String, Object> map, String key) {
        return getMapValue(map, key, ".");
    }

    @Nullable
    private static Object getMapValue(Map<String, Object> map, String key, String delimiter) {
        String[] keys = key.split(Pattern.quote(delimiter));
        Object value = map;
        for (String k : keys) {
            if (!(value instanceof Map)) {
                return null;
            }
            value = ((Map) value).get(k);
            if (value == null) {
                return null;
            }
        }
        return value;
    }


    @Deprecated
    public HashMap<String, String> getManual() {
        return manual;
    }

    @Override
    public String toString() {
        if (labWork.isEmpty()) {
            return "\u001B[31m Collection is empty!";
        } else {
            return "\u001B[32m Collection type: \u001B[0m " + labWork.getClass() + "\n" +
                    "\u001B[32m Collection size: \u001B[0m " + labWork.size() + "\n" +
                    "\u001B[32m Collection elements: \u001B[0m " + initDate + "\n";
        }
    }

    public static LinkedHashSet<LabWork> getCollection() {
        return labWork;
    }

}

