import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        final int FUEL_CONSUMPTION = 12;
        int timeSpent = scanner.nextInt();
        int averageSpeed = scanner.nextInt();
        double distanceTraveled = (double) averageSpeed * (double) timeSpent;
        double fuelSpent = distanceTraveled / FUEL_CONSUMPTION;

        System.out.println(String.format("%.3f", fuelSpent));

        scanner.close();
    }
}