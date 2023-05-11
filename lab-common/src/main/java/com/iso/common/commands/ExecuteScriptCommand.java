package com.iso.common.commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.iso.common.exceptions.CommandArgumentException;
import com.iso.common.network.Request;
import com.iso.common.network.RequestBody;
import com.iso.common.network.Response;
import com.iso.common.userio.BasicUserIO;
import com.iso.common.util.TerminalColors;

public class ExecuteScriptCommand extends AbstractCommand {
    private Set<File> openedFiles = new HashSet<>();

    public ExecuteScriptCommand() {
        super("execute_script");
    }

    @Override
    public String getUsage() {
        return TerminalColors.colorString("execute_script [fileName]", TerminalColors.GREEN)
             + " - reads and executes the content in file as user input";
    }

    public RequestBody packageBody(String[] args, BasicUserIO io) throws CommandArgumentException {
        if (args.length != 1) {
            throw new CommandArgumentException(this.getName(), 1, args.length);
        }

        File file = new File(args[0]);

        if (openedFiles.contains(file)) {
            throw new CommandArgumentException("Potential recursion with file \"" + args[0] + '"');
        }

        openedFiles.add(file);

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(file)) {
                @Override
                public void close() throws IOException {
                    super.close();
                    ExecuteScriptCommand.this.openedFiles.remove(file);
                }
            };
            // File will be closed by IO manager
            io.attachIn(fileReader);
        } catch (FileNotFoundException e) {
            throw new CommandArgumentException("Cannot locate file with the name " + args[0]);
        }

        // This command does not send anything to the server
        return null;
    }

    public Response execute(Request request) {
        throw new UnsupportedOperationException();
    }
}
