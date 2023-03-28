package logic;

import ch.qos.logback.classic.Logger;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import objects.DifficultyComparator;
import objects.Discipline;
import objects.LabWork;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class Editor {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(ServerRunner.class);

    static HashMap <String, LabWork> collection;
    static String filename = System.getenv().getOrDefault("LABFILEPATH", "collection.json");

    public Editor() {
        readCollectionFromFile();
        }

    private void readCollectionFromFile() {
        try {
            logger.info("Opening " + filename);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            File file = new File(filename.trim());
            file.setReadable(true);
            TypeReference <HashMap <String, LabWork>> typeRef = new TypeReference <HashMap <String, LabWork>>() {
            };
            collection = objectMapper.readValue(file.getAbsoluteFile(), typeRef);
        } catch (FileNotFoundException e) {
            logger.error("Could not open the file " + e);
            System.exit(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public HashMap<String, LabWork> getCollection() {
        return collection;
    }

    public void setCollection(HashMap<String, LabWork> collection) {
        this.collection = collection;
    }

    public String getNiceLookingString() {
        if (collection.isEmpty()) {
            return "\u001B[31mCollection is clear, so there's no objects to show their fuel type ¯\\_(ツ)_/¯\u001B[0m";
        } else {
            String template = "\n%5s %8s %8s %8s %20s %23s %12s %13s %30s\n";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String.format(template,
                    "key", "id", "name", "author", "coords", "creation_date", "min_point", "difficulty", "discipline")));
            collection.keySet().stream().forEach(key ->stringBuilder.append(String.format(template,key, "" + collection.get(key).getId(),
                    collection.get(key).getName(), collection.get(key).getAuthor(), collection.get(key).getCoordinates(),
                    collection.get(key).getCreationDate().toString(), collection.get(key).getMinimalPoint(), collection.get(key).getDifficulty(),
                    collection.get(key).getDiscipline())));
            return stringBuilder.toString();
        }
    }


    public String getStringCollection() {
        return collection.toString();
    }


    public void removeIfLower(String key, LabWork labWork) {
        if (collection.get(key).compareTo(labWork) < 0) collection.remove(key);
    }

    public void removeElementByKey(String key) {
        collection.remove(key);
    }

    public void clear() {
        collection.clear();
    }

    public void removeAllLowerByLabwork(LabWork labWork) {
        ArrayList <String> toDeleteKeys = new ArrayList<>();
        for (String key: collection.keySet()) {
            if (collection.get(key).compareTo(labWork) < 0) toDeleteKeys.add(key);
        }
        for (String key3: toDeleteKeys) collection.remove(key3);
    }

    public String getAverageMinimalPoint() {
        long result = 0;
        if (collection.size() == 0) return String.valueOf(result);
        result = collection.values().stream().mapToLong(LabWork::getMinimalPoint).sum();
        return String.valueOf(result / collection.size());
    }

    public String getDescendingDifficulty() {
        //collection.values().stream().collect(Collectors.toList());
        //ArrayList<Difficulty> difficulties = new ArrayList<>();
        //collection.values().forEach(s -> difficulties.add(s.getDifficulty()));
        //difficulties.sort(new DifficultyComparator());
        StringBuilder result = new StringBuilder();
        collection.values().stream().map(LabWork::getDifficulty).sorted(new DifficultyComparator()).forEach(s->result.append(s.toString()).append(" "));
        //difficulties.forEach(difficulty -> result.append(difficulty.toString()).append(" "));
        return result.toString();
    }

    public String removeByDiscipline(Discipline discipline) {
        for (String key: collection.keySet()) {
            if (collection.get(key).getDiscipline().equals(discipline)) {
                collection.remove(key);
                return "Successfully removed element.";
            }
        }
        return "No matches.";
    }

    public void update(int id, LabWork labWork) {
        boolean notFound = true;
        for (String key: collection.keySet()) {
            LabWork labWork1 = collection.get(key);
            if (labWork1.getId() == id) {
                labWork1.copyFromLabwork(labWork);
                notFound = false;
            }
        }
        if (notFound) throw new NoSuchElementException();

    }

    public void insert(String key, LabWork labwork) {
        collection.put(key, labwork);
    }

    public void save()  {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        File file = Paths.get(filename).toFile();
        file.setWritable(true);
        try {
            writer.writeValue(Files.newOutputStream(file.toPath()), collection);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
