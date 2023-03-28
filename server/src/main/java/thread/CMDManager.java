package thread;

import commands.noinput.Save;
import logic.Editor;
import logic.InputData;
import logic.OutputData;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Logger;
import commands.Command;
import henchmen.CommandHistory;
import henchmen.FabricForCommands;


import java.io.IOException;
import java.util.*;

public class CMDManager implements Runnable{
    private CommandHistory commandHistory = new CommandHistory();
    private final Logger logger
            = (Logger) LoggerFactory.getLogger(CMDManager.class);
    private final ArrayList<Command> commands = new ArrayList<>();
    private Editor editor;
    private final ClientData clientData;

    public CMDManager(ClientData clientData) throws IOException {
        FabricForCommands fabricForCommands = new FabricForCommands();
        commands.addAll(fabricForCommands.getAllCommandsArrayList());
        editor = new Editor();
        this.clientData = clientData;
    }

    private String getHistory(int number) {
        return clientData.getCommandHistory();
    }

    public OutputData execute(InputData inputData) {
        return getOutputData(inputData.getCommandName(), inputData, editor);
    }

    private OutputData getOutputData(String justCommand, InputData inputData, Editor editor) {
        long startTime = System.currentTimeMillis();
        Command command = getCommandByString(justCommand);
        logger.info(String.format("Validating command: %s for %s", justCommand, clientData.getClientAddress()));
        if (inputData.getCommandArg() != null)
            commandHistory.add(justCommand + " " + inputData.getCommandArg());
        else commandHistory.add(justCommand);
        logger.warn(String.format("Executing command: %s for %s", justCommand, clientData.getClientAddress()));
        if (justCommand.equals("history")) {
            logger.warn("Recognized history.");
            return new OutputData("Success", getHistory(7));
        }
        OutputData result;
        synchronized (editor) {
            try {
                result = command.exec(editor, inputData);
                logger.warn("Executed command: " + justCommand + " for " + clientData.getClientAddress());
            } catch (NullPointerException e) {
                logger.error("Command was not found.");
                result = new OutputData("Error", "Command was not found. Try again.");
            }
        }
        long endTime = System.currentTimeMillis();

        logger.info(justCommand + ": That took " + (endTime - startTime) + " milliseconds");
        return result;
    }

    private Command getCommandByString(String command) {
        for (Command command1: commands) {
            if (command1.getName().equals(command)) {
                return command1;
            }
        }
        return null;
    }


    public Editor getCollection() {
        return editor;
    }

    public OutputData save() {
        return new Save().exec(editor, new InputData());
    }

    @Override
    public void run() {
        try {
            InputData inputData = clientData.getInputData();
            ClientData saved = new ClientData();
            // он нужен, чтобы всё работало :)
            saved.setClientAddress(clientData.getClientAddress());
            saved.setConnected(clientData.isConnected());
            saved.setCommandHistory(clientData.getCommandHistoryArray());
            saved.setDatagramChannel(clientData.getDatagramChannel());
            saved.setOutputData(execute(inputData));
            AllThreadsDataQueues.toWriteQueue.add(saved);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
