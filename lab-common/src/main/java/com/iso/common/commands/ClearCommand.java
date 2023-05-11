package com.iso.common.commands;

import com.iso.common.collectionmanagers.CollectionManager;
import com.iso.common.network.Request;
import com.iso.common.network.Response;
import com.iso.common.util.TerminalColors;

public class ClearCommand extends AbstractCommand {
    private CollectionManager col;

    public ClearCommand(CollectionManager col) {
        super("clear");
        this.col = col;
    }

    @Override
    public String getUsage() {
        return TerminalColors.colorString("clear", TerminalColors.GREEN) + " - clears the entire collection";
    }

    @Override
    public Response execute(Request request) {
        col.removeIf(x -> x.getOwner().equals(request.getAuth().getLogin()));

        return new Response("Collection cleared");
    }
}
