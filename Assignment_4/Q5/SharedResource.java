package Q5;

import java.util.concurrent.*;

public class SharedResource {
    // Semaphores to control access to hay and cows
public final Semaphore haySemaphore = new Semaphore(5);
public final Semaphore waterSemaphore = new Semaphore(3);
public CyclicBarrier walkBarrier;

    public SharedResource(int n) {
        walkBarrier = new CyclicBarrier(n);
    }

}
