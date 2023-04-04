package logic;

import interfaces.AbstractUI;
import interfaces.CLI;
import interfaces.UI;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Logger;

import java.io.*;
import java.net.PortUnreachableException;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class ResponseHandler extends Thread {

    RequestHandler requestHandler;
    UI ui;
    public Logger logger = (Logger) LoggerFactory.getLogger(ResponseHandler.class);

    public ResponseHandler(RequestHandler requestHandler, UI ui2) {
        this.requestHandler = requestHandler;
        ui = ui2;
    }

    @Override
    public void run() {
        while (requestHandler.isRunnable()) {
            if (requestHandler.getChannel().isOpen()) {
                try {
                    ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = requestHandler.getChannel().read(ByteBuffer.wrap(buffer))) > 0) {
                        byteStream.write(buffer, 0, bytesRead);
                    }
                    byte[] incomingData = byteStream.toByteArray();

                    if (incomingData.length > 0) {
                        ByteArrayInputStream in = new ByteArrayInputStream(incomingData);
                        ObjectInputStream is = new ObjectInputStream(in);
                        OutputData answer = (OutputData) is.readObject();
                        logger.info("OutputData has been received.");
                        logger.warn(answer.getResultMessage());
                        if (answer.getResultMessage().equals("connected")) {
                            requestHandler.setConnected(true);
                            System.out.println("Connection with server has been established!");
                            logger.info("Connection with server has been established!");
                        } else {
                            ui.display(answer);
                        }
                    }
                } catch (PortUnreachableException e) {
                    ui.display("Error", "Не удалось подключиться к серверу");
                } catch (ClassNotFoundException e) {
                    ui.display("Error", "Не удалось определить класс, возможно что-то с сериализацией данных или недостаток размера буфера");
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
                    ex.printStackTrace();
                }
            }
        }
    }
}
