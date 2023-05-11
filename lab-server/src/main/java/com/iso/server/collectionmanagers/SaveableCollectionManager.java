package com.iso.server.collectionmanagers;

import java.io.FileNotFoundException;

import com.iso.common.collectionmanagers.CollectionManager;

public interface SaveableCollectionManager extends CollectionManager {
    void save() throws FileNotFoundException;
}
