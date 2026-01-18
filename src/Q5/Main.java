package Q5;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of cows: ");
        int n = scanner.nextInt();

        SharedResource sharedResource = new SharedResource(n);
        Compounds compounds = new Compounds(n);

        for(int i = 1; i < n; i++) {
            cowThread cow = new cowThread(i, sharedResource, compounds);
            cow.start();
        }

    }
}
