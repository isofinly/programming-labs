package logic;

import interfaces.UI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.PortUnreachableException;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;

public class ResponseHandler extends Thread{

    RequestHandler requestHandler;
    UI ui;
    private Logger logger = LoggerFactory.getLogger(ResponseHandler.class);

    public ResponseHandler(RequestHandler requestHandler, UI ui2) {
        this.requestHandler = requestHandler;
        ui = ui2;
    }

    @Override
    public void run() {
        boolean lastCommandSent = false; // create a flag to keep track of whether the last command was sent or not

        while (requestHandler.isRunnable()) {
            if (requestHandler.getChannel().isOpen()) {
                try {
                    ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[2048];
                    int bytesRead;
                    boolean successOrErrorReceived = false;
                    while ((bytesRead = requestHandler.getChannel().read(ByteBuffer.wrap(buffer))) > 0) {
                        byteStream.write(buffer, 0, bytesRead);
                        if (new String(buffer, 0, bytesRead).contains("Success")
                                || new String(buffer, 0, bytesRead).contains("Please")
                                || new String(buffer, 0, bytesRead).contains("Успешно")
                        ) {
                            successOrErrorReceived = true;
                            break;
                        }
                    }
                    byte[] incomingData = byteStream.toByteArray();

                    if (incomingData.length > 0) {
                        ByteArrayInputStream in = new ByteArrayInputStream(incomingData);
                        ObjectInputStream is = new ObjectInputStream(in);
                        OutputData answer = (OutputData) is.readObject();
                        if (answer.getResultMessage().equals("connected")) {
                            requestHandler.setConnected(true);
                        } else {
                            ui.display(answer);
                        }
                    }
                    if (!successOrErrorReceived && !lastCommandSent) {
                        InputData inputData = new InputData();
                        inputData.setCommandName(requestHandler.getLastCommand().getCommandName());
                        requestHandler.send(inputData);
                        lastCommandSent = true; // set the flag to true after sending the last command
                    } else {
                        lastCommandSent = true; // set the flag to true if a success or error message is received
                    }
                }


                catch (PortUnreachableException e) {
                    ui.display("Error", "Не удалось подключиться к серверу");
                } catch (ClassNotFoundException e) {
                    ui.display("Error", "Не удалось определить класс, возможно что-то с сериализацией данных");
                    requestHandler.setRunnable(false);
                } catch (StreamCorruptedException e) {
//                    ui.display("Error","Какие-то проблемы с потоком данных");
                } catch (EOFException e) {
                    ui.display("Error", "Пожалуйста, не надо пытаться скормить большие данные, UDP становится слишком плохо от этого. \nЯ потеряль пакетики... или перепутал их... простите........ \nПопытайтесь снова, может, получится, а может, и нет. \n " +
                            "           /\\_/\\  \n" +
                            "          ( o   o )\n" +
                            "         ==_~_~_~_==\n" +
                            "       /   /   \\   \\\n" +
                            "      (^(O)^)_(^O^)^)\n" +
                            "      \n");
                } catch (UTFDataFormatException e) {
                    ui.display("Error", "что-то пошло не так.....");
                }catch (IOException ex) {
//                    ex.printStackTrace();
                }
            }
        }
    }
}
