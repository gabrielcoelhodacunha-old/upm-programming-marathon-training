import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        double oldPrice = scanner.nextDouble();
        double newPrice = scanner.nextDouble();
        double priceIncrease = newPrice - oldPrice;
        double increasePercentage = (priceIncrease / oldPrice) * 100;

        System.out.println(String.format("%.2f%%", increasePercentage));

        scanner.close();
    }
}