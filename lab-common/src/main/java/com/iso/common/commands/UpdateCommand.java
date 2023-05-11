package com.iso.common.commands;

import com.iso.common.collectionmanagers.CollectionManager;
import com.iso.common.exceptions.CommandArgumentException;
import com.iso.common.exceptions.InvalidFieldException;
import com.iso.common.exceptions.InvalidRequestException;
import com.iso.common.modelmakers.RouteMaker;
import com.iso.common.models.Route;
import com.iso.common.network.Request;
import com.iso.common.network.RequestBody;
import com.iso.common.network.RequestBodyWithRoute;
import com.iso.common.network.Response;
import com.iso.common.userio.BasicUserIO;
import com.iso.common.util.TerminalColors;

public class UpdateCommand extends AbstractCommand {
    private CollectionManager col;

    public UpdateCommand(CollectionManager col) {
        super("update");
        this.col = col;
    }

    public String getUsage() {
        return TerminalColors.colorString("update [id]", TerminalColors.GREEN)
             + " - updates the element with the specified id.";
    }

    @Override
    public RequestBody packageBody(String[] args, BasicUserIO io) throws CommandArgumentException {
        if (args.length != 1) {
            throw new CommandArgumentException(getName(), 1, args.length);
        }

        try {
            Long id = Long.parseLong(args[0]);
            Route route = RouteMaker.parseRoute(io, id);
            return new RequestBodyWithRoute(args, route);
        } catch (NumberFormatException e) {
            throw new CommandArgumentException("id is not a valid number", e);
        } catch (InvalidFieldException e) {
            io.writeln(TerminalColors.colorString("Failed to update route", TerminalColors.RED));
            io.writeln(e);
            return null;
        }
    }

    @Override
    public Response execute(Request request) throws InvalidRequestException {
        if (request.getBody() == null || !(request.getBody() instanceof RequestBodyWithRoute)) {
            throw new InvalidRequestException("Request should have a route attached", null);
        }

        Route route = ((RequestBodyWithRoute) request.getBody()).getRoute();
        route.setOwner(request.getAuth().getLogin());

        if (!col.update(route)) {
            throw new InvalidRequestException(new CommandArgumentException("No item with specified id was found in collection"), null);
        }
        return new Response("Updated");
    }
}
