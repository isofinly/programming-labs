package src.IO;

import java.io.*;

public class FileHandler {

    public static String fileHandlerOpen(File file) throws IOException{
        //open file and read with bufferedInputStream
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
            return "File not found exeption";
        }
        catch(IOException e) {
            return "Error reading file exeption";
        }
    }

    public static void fileHandlerWrite(String fileName, String fileContent ) throws IOException{
        // wtite file with BufferedWriter
        try{
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
            fileWriter.write(fileContent);
            fileWriter.close();
        }
        catch(IOException e) {
            System.out.println("Error writing file exeption");
        }
    }

    public static int lineCounter(String fileName) throws IOException{
        // wtite file with BufferedWriter
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            reader.close();
            return lines;
        }
        catch(IOException e) {
            System.out.println("Error writing file exeption");
        }
        return 0;
    }

}