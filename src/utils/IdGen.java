package src.utils;

import java.util.concurrent.atomic.AtomicInteger;

public final class IdGen {
    private static final AtomicInteger int_id_counter = new AtomicInteger(0);

    public static int getNewId() {
        return int_id_counter.incrementAndGet();
    }
}
