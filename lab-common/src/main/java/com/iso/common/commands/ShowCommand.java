package com.iso.common.commands;

import com.iso.common.collectionmanagers.CollectionManager;
import com.iso.common.models.Route;
import com.iso.common.network.Request;
import com.iso.common.network.Response;
import com.iso.common.network.ResponseWithRoutes;

public class ShowCommand extends AbstractCommand {
    private CollectionManager col;

    public ShowCommand(CollectionManager col) {
        super("show");
        this.col = col;
    }

    public String getUsage() {
        return "Outputs every item in the collection.";
    }

    @Override
    public Response execute(Request request) {
        Route[] a = new Route[col.getCollection().size()];
        return new ResponseWithRoutes(col.getCollection().toArray(a));
    }
}
