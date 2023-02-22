package src.utils;

import java.io.*;

/**
 * File handler. Uses BufferedInputStream and BufferedWriter to read and write files.
 * Has child class ParserEnv
 * @see ParserEnv
 */
public class FileHandler {

    public static String fileHandlerOpen(File file) {
        try{
            String fileContent = "";
            BufferedInputStream fileReader = new BufferedInputStream(new FileInputStream(file));
            int fileReaderInt = fileReader.read();
            while(fileReaderInt != -1){
                fileContent += (char)fileReaderInt;
                fileReaderInt = fileReader.read();
            }
            fileReader.close();
            return fileContent;
        }
        catch(FileNotFoundException e) {
            return "\u001B[31m File not found exception";
        }
        catch(IOException e) {
            return "\u001B[31m Error reading file exception";
        }
    }

    public static void fileHandlerWrite(String fileName, String fileContent ) {
        try{
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
            fileWriter.write(fileContent);
            fileWriter.close();
        }
        catch(IOException e) {
            System.err.println(" Error writing file exception");
        }
    }

    public static int lineCounter(String fileName) {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            reader.close();
            return lines;
        }
        catch(IOException e) {
            System.err.println(" Error writing file exception");
        }
        return 0;
    }

}