package com.iso.common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.iso.common.collectionmanagers.CollectionManager;
import com.iso.common.commands.AbstractCommand;
import com.iso.common.commands.AddCommand;
import com.iso.common.commands.ClearCommand;
import com.iso.common.commands.ExecuteScriptCommand;
import com.iso.common.commands.ExitCommand;
import com.iso.common.commands.HeadCommand;
import com.iso.common.commands.HelpCommand;
import com.iso.common.commands.InfoCommand;
import com.iso.common.commands.LoginCommand;
import com.iso.common.commands.PrintUniqueDistance;
import com.iso.common.commands.RegisterCommand;
import com.iso.common.commands.RemoveAllByDistanceCommand;
import com.iso.common.commands.RemoveByIdCommand;
import com.iso.common.commands.RemoveFirstCommand;
import com.iso.common.commands.RemoveGreaterCommand;
import com.iso.common.commands.ShowCommand;
import com.iso.common.commands.SumOfDistanceCommand;
import com.iso.common.commands.UpdateCommand;
import com.iso.common.exceptions.CommandArgumentException;
import com.iso.common.exceptions.CommandNotFoundException;
import com.iso.common.exceptions.InvalidRequestException;
import com.iso.common.exceptions.UnauthenticatedException;
import com.iso.common.network.Request;
import com.iso.common.network.RequestBody;
import com.iso.common.network.Response;
import com.iso.common.network.ResponseWithException;
import com.iso.common.userio.BasicUserIO;
import com.iso.common.usermanagers.AuthCredentials;
import com.iso.common.usermanagers.UserManager;

public class CommandHandler {
    private HashMap<String, AbstractCommand> commands = new HashMap<>();

    public static CommandHandler standardCommandHandler(CollectionManager cm, UserManager users) {
        CommandHandler ch = new CommandHandler();
        ch.addCommand(new HelpCommand(ch));
        ch.addCommand(new InfoCommand(cm));
        ch.addCommand(new ShowCommand(cm));
        ch.addCommand(new AddCommand(cm));
        ch.addCommand(new RemoveByIdCommand(cm));
        ch.addCommand(new UpdateCommand(cm));
        ch.addCommand(new ExitCommand());
        ch.addCommand(new ClearCommand(cm));
        ch.addCommand(new SumOfDistanceCommand(cm));
        ch.addCommand(new HeadCommand(cm));
        ch.addCommand(new RemoveFirstCommand(cm));
        ch.addCommand(new RemoveGreaterCommand(cm));
        ch.addCommand(new RemoveAllByDistanceCommand(cm));
        ch.addCommand(new PrintUniqueDistance(cm));
        ch.addCommand(new ExecuteScriptCommand());
        ch.addCommand(new RegisterCommand(users));
        ch.addCommand(new LoginCommand(users));

        return ch;
    }

    public Request handleString(String commandString, BasicUserIO io, AuthCredentials auth) throws CommandNotFoundException, CommandArgumentException {
        String[] commandArgs = commandString.trim().split("\\s+");

        AbstractCommand command = commands.get(commandArgs[0]);

        if (command == null) {
            throw new CommandNotFoundException(commandArgs[0]);
        }

        RequestBody body = command.packageBody(Arrays.copyOfRange(commandArgs, 1, commandArgs.length), io);
        if (body == null) {
            return null;
        }
        Request request = new Request(command.getName(), body, auth);
        return request;
    }

    public Response handleRequest(Request request, UserManager users) {
        if (commands.get(request.getCommandName()) != null) {
            Long userId = users.authenticate(request.getAuth());

            if (userId == null && commands.get(request.getCommandName()).requiresAuth()) {
                return new ResponseWithException(new UnauthenticatedException());
            }

            try {
                return commands.get(request.getCommandName()).execute(request);
            } catch (InvalidRequestException e) {
                return new ResponseWithException(e);
            }
        }

        return new ResponseWithException(new CommandNotFoundException(request.getCommandName()));
    }

    public void addCommand(AbstractCommand command) {
        commands.put(command.getName(), command);
    }

    public Map<String, AbstractCommand> getCommands() {
        return this.commands;
    }
}
