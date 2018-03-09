package duration;

import java.time.Duration;
import java.time.Instant;

public class StringCreationStudies {

    public long measureStringCreationTimeRequiredOnHeap(int objectsCount) {
        Instant start = Instant.now();

        for (int i = 0; i < objectsCount; i++) {
            String s = new String("test");

        }

        long d = Duration.between(start, Instant.now()).toMillis();
        System.out.println("Heap:" + d);
        return d;

    }

    public long measureStringCreationTimeRequiredInPool(int objectsCount) {
        Instant start = Instant.now();

        for (int i = 0; i < objectsCount; i++) {
            String s = "test";

        }
        long d = Duration.between(start, Instant.now()).toMillis();
        System.out.println("Pool:" + d);
        return d;
    }

}
