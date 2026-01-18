package Q5;

import java.util.Random;

public class CowThread extends Thread {
private final int id;
private final SharedResource res;
private final Compounds comp;
private final Random random = new Random();


public CowThread(int id, SharedResource res, Compounds comp) {
    this.id = id;
    this.res = res;
    this.comp = comp;
}


    private void randomSleep() throws InterruptedException {
        int sleepTime = (random.nextInt(9) + 2) * 1000;
        Thread.sleep(sleepTime);
    }

@Override
    public void run() {
    try {
        //eating hay
        res.haySemaphore.acquire();
        comp.eat(id);
        randomSleep();
        comp.finishEating(id);
        res.haySemaphore.release();

        //drinking water
        res.waterSemaphore.acquire();
        comp.drink(id);
        randomSleep();
        comp.finishDrinking(id);
        res.waterSemaphore.release();

        System.out.println("cow " + id + " is waiting at the barrier to walk.");
        res.walkBarrier.await(); //wait for all cows to be ready to walk

        //walking
        comp.walk(id);
        randomSleep();
        System.out.println("cow " + id + " has finished walking.");

    } catch (Exception e) {
        System.out.println("cow " + id + "was interrupted: ");
    }
}

}
