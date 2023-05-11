package com.iso.common.commands;

import com.iso.common.LocaleKeys;
import com.iso.common.collectionmanagers.CollectionManager;
import com.iso.common.exceptions.CommandArgumentException;
import com.iso.common.exceptions.InvalidFieldException;
import com.iso.common.exceptions.InvalidRequestException;
import com.iso.common.modelmakers.RouteMaker;
import com.iso.common.network.Request;
import com.iso.common.network.RequestBody;
import com.iso.common.network.RequestBodyWithRoute;
import com.iso.common.network.Response;
import com.iso.common.userio.BasicUserIO;
import com.iso.common.util.TerminalColors;

public class AddCommand extends AbstractCommand {
    private CollectionManager col;

    public AddCommand(CollectionManager col) {
        super("add");
        this.col = col;
    }

    public String getUsage() {
        return TerminalColors.colorString("add", TerminalColors.GREEN)
             + " - Starts route creation";
    }

    @Override
    public RequestBody packageBody(String[] args, BasicUserIO io) throws CommandArgumentException {
        if (args.length != 0) {
            throw new CommandArgumentException(this.getName(), args.length);
        }

        try {
            return new RequestBodyWithRoute(args, RouteMaker.parseRoute(io, 1L));
        } catch (InvalidFieldException e) {
            io.writeln(TerminalColors.colorString("Failed to create new route", TerminalColors.RED));
            io.writeln(e.getMessage());
            return null;
        }
    }

    @Override
    public Response execute(Request request) throws InvalidRequestException {
        if (request.getBody() == null || !(request.getBody() instanceof RequestBodyWithRoute)) {
            throw new InvalidRequestException("Request should have a route attached", LocaleKeys.INVALID_VALUE);
        }

        RequestBodyWithRoute body = (RequestBodyWithRoute) request.getBody();

        body.getRoute().setOwner(request.getAuth().getLogin());

        long newId = col.add(body.getRoute());

        if (newId == 0) {
            return new Response("Failed to add route");
        } else {
            return new Response("Route added, assigned id " + newId);
        }
    }
}
