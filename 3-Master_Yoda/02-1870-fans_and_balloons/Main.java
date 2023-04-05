import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int lines = scanner.nextInt();
            int columns = scanner.nextInt();
            int position = scanner.nextInt();
            if (lines == 0 && columns == 0 && position == 0) {
                break;
            }
            int matrix[][] = new int[lines][columns];
            fillMatrix(matrix, scanner);
            releaseBalloon(matrix, position - 1);
        }

        scanner.close();
    }

    private static void fillMatrix(int matrix[][], Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static void releaseBalloon(int matrix[][], int position) {
        for (int row = 0; row < matrix.length; row++) {
            int closestLeftFanForce = getClosestLeftFanForce(matrix, row, position);
            int closestRightFanForce = getClosestRightFanForce(matrix, row, position);
            position += closestLeftFanForce - closestRightFanForce;
            if (exploded(matrix, row, position)) {
                printBoom(row, position);
                return;
            }
        }
        printOut(position);
    }

    private static int getClosestLeftFanForce(int matrix[][], int row, int position) {
        int closestLeftFanForce = 0;
        for (int closestLeftFanPosition = position - 1; closestLeftFanPosition >= 0; closestLeftFanPosition--) {
            closestLeftFanForce = matrix[row][closestLeftFanPosition];
            if (closestLeftFanForce > 0) {
                break;
            }
        }
        return closestLeftFanForce;
    }

    private static int getClosestRightFanForce(int matrix[][], int row, int position) {
        int closestRightFanForce = 0;
        for (int rightmostFanPosition = position + 1; rightmostFanPosition < matrix[0].length; rightmostFanPosition++) {
            closestRightFanForce = matrix[row][rightmostFanPosition];
            if (closestRightFanForce > 0) {
                break;
            }
        }
        return closestRightFanForce;
    }

    private static boolean exploded(int matrix[][], int row, int position) {
        return matrix[row][position] > 0;
    }

    private static void printBoom(int row, int column) {
        printLine(String.format("BOOM %d %d", row + 1, column + 1));
    }

    private static void printOut(int column) {
        printLine(String.format("OUT %d", column + 1));
    }

    private static void printLine(String message) {
        System.out.println(message);
    }
}