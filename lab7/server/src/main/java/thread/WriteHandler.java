package thread;

import logic.InputData;
import logic.OutputData;
import logic.ServerRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;

public class WriteHandler implements Runnable{
    private static final Logger logger = LoggerFactory.getLogger(WriteHandler.class);
    private ClientData clientData;

    public WriteHandler(ClientData clientData) {
        System.out.println(clientData.getClientAddress() + " " + clientData.getOutputData().getResultMessage());
        this.clientData = clientData;
    }

    @Override
    public void run() {
        OutputData answer = clientData.getOutputData();
        if(answer != null) {
            try {
                // Retrieve the DatagramChannel from clientData
                DatagramChannel channel = clientData.getDatagramChannel();

// Serialize answer and write to a ByteArrayOutputStream
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                try (ObjectOutputStream os = new ObjectOutputStream(outputStream)) {
                    os.writeObject(answer);
                }

// Convert ByteArrayOutputStream to a byte array
                byte[] replyBytes = outputStream.toByteArray();

// Define the maximum chunk size
                int chunkSize = 2048;

// Send replyBytes in chunks of chunkSize bytes
                for (int i = 0; i < replyBytes.length; i += chunkSize) {
                    int endIndex = Math.min(i + chunkSize, replyBytes.length);
                    ByteBuffer chunk = ByteBuffer.wrap(replyBytes, i, endIndex - i);
                    channel.send(chunk, clientData.getClientAddress());
                }

                logger.info("Sending answer to " + clientData.getClientAddress());
                logger.info("Sent answer " + replyBytes.length + " bytes");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
//@Override
//public void run() {
//    OutputData answer = clientData.getOutputData();
//    if(answer != null) {
//        try {
//            // Retrieve the DatagramChannel from clientData
//            DatagramChannel channel = clientData.getDatagramChannel();
//
//            // Serialize answer and write to a ByteArrayOutputStream
//            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//            try (ObjectOutputStream os = new ObjectOutputStream(outputStream)) {
//                os.writeObject(answer);
//            }
//
//            // Convert ByteArrayOutputStream to a byte array
//            byte[] replyBytes = outputStream.toByteArray();
//
//            // Define the maximum chunk size
//            int chunkSize = 2048;
//
//            // Send replyBytes in chunks of chunkSize bytes with packet number
//            for (int i = 0, packetNumber = 0; i < replyBytes.length; i += chunkSize, packetNumber++) {
//                int endIndex = Math.min(i + chunkSize, replyBytes.length);
//                ByteBuffer chunk = ByteBuffer.allocate(endIndex - i + 4); // add 4 bytes for packet number
//                chunk.putInt(packetNumber); // add packet number to the buffer
//                chunk.put(replyBytes, i, endIndex - i);
//                chunk.flip();
//                channel.send(chunk, clientData.getClientAddress());
//            }
//
//            logger.info("Sending answer to " + clientData.getClientAddress());
//            logger.info("Sent answer " + replyBytes.length + " bytes");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}

}
