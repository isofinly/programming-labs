package com.iso.common.commands;

import com.iso.common.collectionmanagers.CollectionManager;
import com.iso.common.exceptions.InvalidRequestException;
import com.iso.common.exceptions.UnauthorizedException;
import com.iso.common.models.Route;
import com.iso.common.network.Request;
import com.iso.common.network.Response;
import com.iso.common.network.ResponseWithException;
import com.iso.common.network.ResponseWithRoutes;
import com.iso.common.util.TerminalColors;

public class RemoveFirstCommand extends AbstractCommand {
    private CollectionManager col;

    public RemoveFirstCommand(CollectionManager col) {
        super("remove_first");
        this.col = col;
    }

    @Override
    public String getUsage() {
        return TerminalColors.colorString("remove_first", TerminalColors.GREEN)
             + " - removes the first element in the collection";
    }

    @Override
    public Response execute(Request request) throws InvalidRequestException {
        if (col.getCollection().isEmpty()) {
            return new Response("The collection is empty");
        }

        Route route = col.getCollection().get(0);

        if (!route.getOwner().equals(request.getAuth().getLogin())) {
            return new ResponseWithException(new UnauthorizedException());
        }

        col.remove(route.getId());
        return new ResponseWithRoutes("The following route is removed: ", new Route[] {route});
    }
}
