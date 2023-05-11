package com.iso.common.commands;

import com.iso.common.LocaleKeys;
import com.iso.common.collectionmanagers.CollectionManager;
import com.iso.common.exceptions.CommandArgumentException;
import com.iso.common.exceptions.InvalidRequestException;
import com.iso.common.network.Request;
import com.iso.common.network.RequestBody;
import com.iso.common.network.Response;
import com.iso.common.userio.BasicUserIO;
import com.iso.common.util.TerminalColors;

public class RemoveAllByDistanceCommand extends AbstractCommand {
    private final CollectionManager col;

    public RemoveAllByDistanceCommand(CollectionManager col) {
        super("remove_all_by_distance");
        this.col = col;
    }

    @Override
    public String getUsage() {
        return TerminalColors.colorString("remove_all_by_distance [distance]", TerminalColors.GREEN)
             + " - removes all items with the specified distance.";
    }

    @Override
    public RequestBody packageBody(String[] args, BasicUserIO io) throws CommandArgumentException {
        if (args.length != 1) {
            throw new CommandArgumentException(this.getName(), args.length);
        }

        try {
            Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            throw new CommandArgumentException("Invalid distance entered.", e);
        }

        return new RequestBody(args);
    }

    @Override
    public Response execute(Request request) throws InvalidRequestException {
        try {
            Double distance = Double.parseDouble(request.getBody().getArg(0));
            int res = col.removeIf(x -> (x.getDistance() != null && x.getDistance().equals(distance) && x.getOwner().equals(request.getAuth().getLogin())));
            return new Response("Removed " + res + " items");
        } catch (NumberFormatException e) {
            throw new InvalidRequestException(new CommandArgumentException("Invalid distance entered.", e), LocaleKeys.INVALID_VALUE);
        }
    }
}
