import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String numberFound = scanner.nextLine();

        printReversed(numberFound);

        scanner.close();
    }

    private static void printReversed(String numberFound) {
        String numberReversed = "";

        for (int i = numberFound.length() - 1; i >= 0; i--)
            numberReversed += numberFound.charAt(i);

        System.out.println(numberReversed);
    }
}