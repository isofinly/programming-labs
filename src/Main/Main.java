package src.Main;

import java.io.*;
import src.IO.*;
import src.Collection.CollectionManager;

public class Main {
    public static void main(String[] args) throws Exception {

        var env_file_input = ParserEnv.envParser("/Users/isofinly/VSC-Projects/pr0og-lab-5/src/.env");
        String inPath = "/Users/isofinly/VSC-Projects/prog-lab-5/src/JSON/input.json";
        String outPath = "/Users/isofinly/VSC-Projects/prog-lab-5/src/JSON/output.json";
        System.out.println(env_file_input.get("COMMAND_1"));
        
        File json_file_input = new File("src/JSON/input.json");
        CollectionManager collectionManager = new CollectionManager(inPath, outPath);


    }
    
}
