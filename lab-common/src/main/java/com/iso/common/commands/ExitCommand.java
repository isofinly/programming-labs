package com.iso.common.commands;

import com.iso.common.network.Request;
import com.iso.common.network.RequestBody;
import com.iso.common.network.Response;
import com.iso.common.userio.BasicUserIO;
import com.iso.common.util.TerminalColors;

public class ExitCommand extends AbstractCommand {
    public ExitCommand() {
        super("exit");
    }

    @Override
    public String getUsage() {
        return TerminalColors.colorString("exit", TerminalColors.GREEN) + " - exits the program";
    }

    @Override
    public RequestBody packageBody(String[] args, BasicUserIO io) {
        io.writeln("Thanks for using my program :)");
        System.exit(0);

        return null;
    }

    @Override
    public Response execute(Request request) {
        throw new UnsupportedOperationException();
    }
}
