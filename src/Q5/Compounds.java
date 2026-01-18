package Q5;
import java.util.concurrent.atomic.AtomicInteger;

public class Compounds {
    private final AtomicInteger hayCount = new AtomicInteger(0);
    private final AtomicInteger waterCount = new AtomicInteger(0);
    public final boolean[] finishedHay;
    public final boolean[] finishedWater;

    public Compounds(int n) {
        finishedHay = new boolean[n + 1];
        finishedWater = new boolean[n + 1];
    }


    public void eat(int id) {
        int current = hayCount.incrementAndGet();
        if (current > 5) {
            System.out.println("Error: More than 5 hay compounds consumed!");
        }
        System.out.println("cow " + id + " is eating hay. current cows : " + current);
        finishedHay[id] = true;
    }

    public void finishEating(int id) {
        int current = hayCount.decrementAndGet();
    }

    public void drink(int id) {
        //first check if a cow has finished eating hay
        if (!finishedHay[id]) {
            System.out.println("Error: cow " + id + " tried to drink water before finishing hay!");
        }
        int current = waterCount.incrementAndGet();
        if (current > 3) {
            System.out.println("Error: too many cows trying to drink water!");
        }
        System.out.println("cow " + id + " is drinking water. current cows : " + current);
        finishedWater[id] = true;
    }

    public void finishDrinking(int id) {
        int current = waterCount.decrementAndGet();
    }

    public void walk(int id) {
        if(!finishedWater[id]) { //check if cow has finished drinking water and eating hay
            System.out.println("Error: cow " + id + " tried to walk before finishing drinking!");
        }
        System.out.println("cow " + id + " is walking.");
    }


}