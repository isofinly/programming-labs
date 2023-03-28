package henchmen;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesGetter {
    public String getInputFileName() throws IOException {
        return System.getenv().getOrDefault("LABFILEPATH", "collection.json");
    }
    public String getOutputFilename() throws IOException {
        return System.getenv().getOrDefault("LABFILEOUTPATH", "out_collection.json");
    }

}
