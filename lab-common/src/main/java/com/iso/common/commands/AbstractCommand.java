package com.iso.common.commands;

import com.iso.common.exceptions.CommandArgumentException;
import com.iso.common.exceptions.InvalidRequestException;
import com.iso.common.network.Request;
import com.iso.common.network.RequestBody;
import com.iso.common.network.Response;
import com.iso.common.userio.BasicUserIO;

public abstract class AbstractCommand {
    private final String name;
    private final boolean requireAuth;

    public AbstractCommand(String name) {
        this.name = name;
        requireAuth = true;
    }

    public AbstractCommand(String name, boolean requireAuth) {
        this.name = name;
        this.requireAuth = requireAuth;
    }

    public String getName() {
        return name;
    }

    public boolean requiresAuth() {
        return requireAuth;
    }

    public RequestBody packageBody(String[] args, BasicUserIO io) throws CommandArgumentException {
        if (args.length != 0) {
            throw new CommandArgumentException(this.getName(), args.length);
        }

        return new RequestBody(args);
    }

    public abstract Response execute(Request request) throws InvalidRequestException;
    public abstract String getUsage();
}
