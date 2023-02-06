package src.main;

import java.io.*;

import src.collection.*;
import src.utils.*;


public class Main {
    public static void main(String[] args) throws Exception {

        var env_file_input = ParserEnv.envParser("/Users/isofinly/VSC-Projects/prog-lab-5/src/.env");
        String inPath = "/Users/isofinly/VSC-Projects/prog-lab-5/src/JSON/input.json";
        String outPath = "/Users/isofinly/VSC-Projects/prog-lab-5/src/JSON/output.json";
        System.out.println(env_file_input.get("COMMAND_1"));
        String json = "{name=Labwork1, coordinates={x=5.0, y=3.0}, minimalPoint=10.0, personalQualitiesMinimum=10.0, personalQualitiesMaximum=12.0, difficulty=HARD, discipline=BIOLOGY}";


        File json_file_input = new File("src/JSON/input.json");
        CollectionManager collectionManager = new CollectionManager(inPath, outPath);
    }
    
}
