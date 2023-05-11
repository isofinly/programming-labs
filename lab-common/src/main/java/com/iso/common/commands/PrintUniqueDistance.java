package com.iso.common.commands;

import com.iso.common.collectionmanagers.CollectionManager;
import com.iso.common.exceptions.InvalidRequestException;
import com.iso.common.network.Request;
import com.iso.common.network.Response;
import com.iso.common.util.TerminalColors;

public class PrintUniqueDistance extends AbstractCommand {
    private CollectionManager col;

    public PrintUniqueDistance(CollectionManager col) {
        super("print_unique_distance");
        this.col = col;
    }

    @Override
    public String getUsage() {
        return TerminalColors.colorString("print_unique_distance", TerminalColors.GREEN)
             + " - prints all distinct distances";
    }

    @Override
    public Response execute(Request request) throws InvalidRequestException {
        StringBuilder sb = new StringBuilder();

        for (Double distance : col.getUniqueDistances()) {
            sb.append(distance.toString() + '\n');
        }

        return new Response(sb.toString());
    }
}
