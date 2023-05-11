package com.iso.common.commands;

import com.iso.common.collectionmanagers.CollectionManager;
import com.iso.common.exceptions.InvalidRequestException;
import com.iso.common.models.Route;
import com.iso.common.network.Request;
import com.iso.common.network.Response;
import com.iso.common.network.ResponseWithRoutes;
import com.iso.common.util.TerminalColors;

public class HeadCommand extends AbstractCommand {
    private CollectionManager col;

    public HeadCommand(CollectionManager col) {
        super("head");
        this.col = col;
    }

    @Override
    public String getUsage() {
        return TerminalColors.colorString("head", TerminalColors.GREEN)
             + " - outputs the first element in the collection";
    }

    @Override
    public Response execute(Request request) throws InvalidRequestException {
        if (col.getCollection().isEmpty()) {
            return new Response("The collection is empty");
        }

        return new ResponseWithRoutes(new Route[] {col.getCollection().get(0)});
    }
}
