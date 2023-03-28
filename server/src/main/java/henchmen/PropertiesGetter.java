package henchmen;

import java.io.IOException;

public class PropertiesGetter {
    public String getInputFileName() throws IOException {
        return System.getenv().getOrDefault("LABFILEPATH", "collection.json");
    }
    public String getOutputFilename() throws IOException {
        return System.getenv().getOrDefault("LABFILEOUTPATH", "out_collection.json");
    }

}
