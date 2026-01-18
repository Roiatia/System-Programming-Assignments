package Q5;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of cows: ");
        int n = scanner.nextInt();

        SharedResource res = new SharedResource(n);
        Compounds comp = new Compounds(n);

        for(int i = 1; i <= n; i++) {
            CowThread cow = new CowThread(i, res, comp);
            cow.start();
        }

    }
}
