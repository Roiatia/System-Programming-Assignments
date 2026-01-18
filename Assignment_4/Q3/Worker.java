package Assignment_4;

public class Worker extends Thread {
    private final SemaphoreExample.SharedResource sharedResource;

    public Worker(String name, SemaphoreExample.SharedResource sharedResource) {
        super(name);
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        sharedResource.accessResource();
    }


}
