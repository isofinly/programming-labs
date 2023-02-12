package src.utils;

import java.io.*;
import java.util.*;

import javax.validation.constraints.NotNull;


/**
 * ParserEnv class. Parses .env file and returns a map with key-value pairs.
 * @see FileHandler
 */
public class ParserEnv extends FileHandler {


    public static @NotNull Map <String, String> envParser(String path) throws IOException {

        int lines = lineCounter(path);
        var fileContent = fileHandlerOpen(new File(path));
        Map <String, String> envMap = new HashMap <>();

        try {
            String[] envArray = fileContent.split("\n", lines);
            for (String env : envArray) {
                String[] envKeyValue = env.split("=", lines);
                envMap.put(envKeyValue[0], envKeyValue[1]);
            }
            return envMap;
        } catch (Exception e) {
            System.out.println("Error parsing .env file");
        }
        return envMap;
    }
}