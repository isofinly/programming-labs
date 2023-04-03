package thread;

import ch.qos.logback.classic.Logger;
import logic.OutputData;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class WriteHandler implements Runnable{
    private static final Logger logger = (Logger) LoggerFactory.getLogger(WriteHandler.class);
    private ClientData clientData;

    public WriteHandler(ClientData clientData) {
        //System.out.println(clientData.getClientAddress() + " " + clientData.getOutputData().getResultMessage());
        this.clientData = clientData;
    }

    @Override
    public void run() {
        OutputData answer = clientData.getOutputData();
        if(answer != null) {
            try {
                DatagramChannel channel = clientData.getDatagramChannel();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ObjectOutputStream os = new ObjectOutputStream(outputStream);
                os.writeObject(answer);
                byte[] replyBytes = outputStream.toByteArray();
                int chunkSize = 1024; // or any other appropriate chunk size
                for (int i = 0; i < replyBytes.length; i += chunkSize) {
                    int endIndex = Math.min(i + chunkSize, replyBytes.length);
                    ByteBuffer buff = ByteBuffer.wrap(replyBytes, i, endIndex - i);
                    channel.send(buff, clientData.getClientAddress());
                }
                logger.info("Sending answer to " + clientData.getClientAddress());
                logger.info("Sent answer " + replyBytes.length + " bytes");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
