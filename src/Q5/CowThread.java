package Q5;

import java.util.Random;

public class CowThread extends Thread {
private final int id;
private final SharedResource sharedResource;
private final Compounds compounds;
private final Random random = new Random();


public cowThread(int id, SharedResource sharedResource, Compounds compounds) {
    this.id = id;
    this.sharedResource = sharedResource;
    this.compounds = compounds;
}


    private void randomSleep() throws interruptedException {
    int sleepTime = (random.nextInt(9) + 2) * 1000; // Sleep between 2 to 10 seconds
    Thread.sleep(sleepTime);

}

@Override
    public void run() {
    try {
        //eating hay
        sharedResource.haySemaphore.acquire();
        compounds.eat(id);
        randomSleep();
        compounds.finishEating(id);
        sharedResource.haySemaphore.release();

        //drinking water
        sharedResource.waterSemaphore.acquire();
        compounds.drink(id);
        randomSleep();
        compounds.finishDrinking(id);
        sharedResource.waterSemaphore.release();

        System.out.println("cow " + id + " is waiting at the barrier to walk.");
        sharedResource.walkBarrier.await(); //wait for all cows to be ready to walk

        //walking
        compounds.walk(id);
        randomSleep();
        System.out.println("cow " + id + " has finished walking.");
    } catch (Exception e) {
        System.out.println("cow " + id + "was interrupted: ");
    }
}

}
