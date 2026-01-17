package Assignment_4;

public class Main {
    public static void main(String[] args) {
        SemaphoreExample.SharedResource sharedResource = new SemaphoreExample.SharedResource(2);

        Thread worker1 = new Worker("Worker-1", sharedResource);
        Thread worker2 = new Worker("Worker-2", sharedResource);
        Thread worker3 = new Worker("Worker-3", sharedResource);
        Thread worker4 = new Worker("Worker-4", sharedResource);

        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();
    }
}
