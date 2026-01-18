package Assignment_4;
import java.util.concurrent.*;
public class SemaphoreExample {
    static class SharedResource {
        private final Semaphore semaphore;

        public SharedResource(int permits) {
            this.semaphore = new Semaphore(permits);
        }

        public void accessResource() {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + "is accessing the resource " );
                Thread.sleep(1000);
            } catch (InterruptedException e)  {
                e.printStackTrace();
            } finally {
                System.out.println( Thread.currentThread().getName() + " is releasing the resource ");
                semaphore.release();
            }
        }
    }
}
