package logic;

import ch.qos.logback.classic.Logger;
import interfaces.CLI;
import org.slf4j.LoggerFactory;
import thread.ClientData;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Arrays;
import java.util.Scanner;

public class ServerRunner {
//    private static int PORT = 26262;
    private static Integer PORT;
    private static boolean running;
    private static DatagramSocket socket;
    private static final Logger logger = (Logger) LoggerFactory.getLogger(ServerRunner.class);
    private static Selector selector;


    public void start() {
        if (running) {
            logger.error("ServerRunner has already started. It's alive!!!!!!!!");
        } else {
                try {
                    logger.info("ServerRunner is starting... \nWaiting for user input of PORT");
                    Scanner userIn = new Scanner(System.in);
                    try {
                    PORT = Integer.parseInt(userIn.nextLine());
                    }
                    catch (NumberFormatException e) {
                        PORT = 2023;
                        logger.error("Type of PORT was " + userIn.getClass().getSimpleName() + " Intended " + PORT.getClass().getSimpleName());
                    }
                    logger.info("Server port was set to " + PORT);
                    logger.info("ServerRunner just started initialization.");
                    running = true;
                    DatagramChannel datagramChannel = DatagramChannel.open();
                    datagramChannel.configureBlocking(false);
                    datagramChannel.bind(new InetSocketAddress(PORT));
                    socket = datagramChannel.socket();
                    selector = Selector.open();
                    new Thread(new CLI()).start();
                    datagramChannel.register(selector, SelectionKey.OP_READ, new ClientData());
                    logger.info("Everything went fine.");
                    SelectorManager.run();
                } catch (SocketException e) {
                    logger.error("SOCKET issue detected...");
                } catch (ClosedChannelException e) {
                    logger.error("Channel appears to be closed...");
                } catch (IOException e) {
                    logger.error("Server didn't start..." + Arrays.toString(e.getStackTrace()));
                }
        }
    }

    public static boolean isRunning() {
        return running;
    }

    public static Selector getSelector() {
        return selector;
    }
}
