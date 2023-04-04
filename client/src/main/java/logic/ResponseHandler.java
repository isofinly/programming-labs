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

//                    ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
//                    byte[] buffer = new byte[8196];
//                    int bytesRead;
//                    int totalBytesRead = 0;
//                    int expectedDataLength = -1;
//                    while ((bytesRead = requestHandler.getChannel().read(ByteBuffer.wrap(buffer))) > 0) {
//                        byteStream.write(buffer, 0, bytesRead);
//                        totalBytesRead += bytesRead;
//                        if (expectedDataLength == -1 && totalBytesRead >= 4) {
//                            // First 4 bytes indicate the expected length of the incoming data
//                            expectedDataLength = ByteBuffer.wrap(byteStream.toByteArray(), 0, 4).getInt();
//                        }
//                        if (totalBytesRead >= expectedDataLength) {
//                            // We've received all the data, break out of the loop
//                            break;
//                        }
//                    }
//                    byte[] incomingData = byteStream.toByteArray();
//                    if (incomingData.length > 0) {
//                        ByteArrayInputStream in = new ByteArrayInputStream(incomingData);
//                        ObjectInputStream is = new ObjectInputStream(in);
//                        OutputData answer = (OutputData) is.readObject();
//                        logger.info("OutputData has been received.");
//                        logger.warn(answer.getResultMessage());
//                        if (answer.getResultMessage().equals("connected")) {
//                            requestHandler.setConnected(true);
//                            System.out.println("Connection with server has been established!");
//                            logger.info("Connection with server has been established!");
//                        } else {
//                            ui.display(answer);
//                        }
//                    }

//                    ByteBuffer buffer = ByteBuffer.allocate(8196*8196);
//                    ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
//                    int bytesRead;
//                    while ((bytesRead = requestHandler.getChannel().read(buffer)) > 0) {
//                        buffer.flip();
//                        byteStream.write(buffer.array(), 0, bytesRead);
//                        buffer.clear();
//                    }
//                    byte[] incomingData = byteStream.toByteArray();
//                    if (incomingData.length > 0) {
//                        ByteArrayInputStream in = new ByteArrayInputStream(incomingData);
//                        ObjectInputStream is = new ObjectInputStream(in);
//                        OutputData answer = (OutputData) is.readObject();
//                        logger.info("OutputData has been received.");
//                        logger.warn(answer.getResultMessage());
//                        if (answer.getResultMessage().equals("connected")) {
//                            requestHandler.setConnected(true);
//                            System.out.println("Connection with server has been established!");
//                            logger.info("Connection with server has been established!");
//                        } else {
//                            ui.display(answer);
//                        }
//                    }


                    ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[8196*8916];
                    int bytesRead;
                    int totalBytesRead = 0;
                    while ((bytesRead = requestHandler.getChannel().read(ByteBuffer.wrap(buffer))) > 0) {
                        byteStream.write(buffer, 0, bytesRead);
                        totalBytesRead += bytesRead;
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
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

