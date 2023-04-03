package logic;

import interfaces.AbstractUI;
import interfaces.CLI;
import interfaces.UI;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Logger;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.net.PortUnreachableException;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class ResponseHandler extends Thread{

    RequestHandler requestHandler;
    UI ui;
    public Logger logger = (Logger) LoggerFactory.getLogger(ResponseHandler.class);

    public ResponseHandler(RequestHandler requestHandler, UI ui2) {
        this.requestHandler = requestHandler;
        ui = ui2;
    }

    @Override
    public void run() {
        while(requestHandler.isRunnable()) {
            if (requestHandler.getChannel().isOpen()) {
                try {
                    byte[] incomingData = new byte[8196*8196];
                    ByteBuffer byteBuffer = ByteBuffer.wrap(incomingData);
                    requestHandler.getChannel().receive(byteBuffer);
                    byteBuffer.flip();
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
                } catch (PortUnreachableException e) {
                    ui.display("Error","Не удалось подключиться к серверу");
                } catch (ClassNotFoundException e) {
                    ui.display("Error","Не удалось определить класс, возможно что-то с сериализацией данных или недостаток размера буфера");
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
