import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        double[] sides = new double[3];
        sides[0] = scanner.nextDouble();
        sides[1] = scanner.nextDouble();
        sides[2] = scanner.nextDouble();

        sortInDecreasingOrder(sides);
        classifyTriangle(sides);

        scanner.close();
    }

    private static void sortInDecreasingOrder(double[] sides) {
        double aux;

        for (int i = 0; i < sides.length; i++) {
            for (int j = 0; j < sides.length; j++) {
                if (sides[i] > sides[j]) {
                    aux = sides[j];
                    sides[j] = sides[i];
                    sides[i] = aux;
                }
            }
        }
    }

    private static void classifyTriangle(double[] sides) {
        double a = sides[0];
        double b = sides[1];
        double c = sides[2];
        double aSquared = Math.pow(a, 2);
        double bSquaredPlusCSquared = Math.pow(b, 2) + Math.pow(c, 2);

        if (a >= b + c)
            print("NAO FORMA TRIANGULO");
        else if (aSquared == bSquaredPlusCSquared)
            print("TRIANGULO RETANGULO");
        else if (aSquared > bSquaredPlusCSquared)
            print("TRIANGULO OBTUSANGULO");
        else if (aSquared < bSquaredPlusCSquared)
            print("TRIANGULO ACUTANGULO");
        if (a == b && a == c)
            print("TRIANGULO EQUILATERO");
        else if ((a == b && a != c) || (b == c && b != a) || (c == a && c != b))
            print("TRIANGULO ISOSCELES");
    }

    private static void print(String message) {
        System.out.println(message);
    }
}