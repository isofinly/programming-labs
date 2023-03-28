package thread;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AllThreadsDataQueues {

    public static Queue<ClientData> toExecuteQueue = new ConcurrentLinkedQueue<>();
    public static Queue<ClientData> toWriteQueue = new ConcurrentLinkedQueue<>();
}
