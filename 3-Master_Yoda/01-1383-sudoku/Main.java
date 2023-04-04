import java.io.IOException;
import java.util.Scanner;

public class Main {
    final static int MATRIX_SIZE = 9;
    final static int SUB_MATRICES[][] = {
            { 0, 0, 0, 1, 1, 1, 2, 2, 2 },
            { 0, 0, 0, 1, 1, 1, 2, 2, 2 },
            { 0, 0, 0, 1, 1, 1, 2, 2, 2 },
            { 3, 3, 3, 4, 4, 4, 5, 5, 5 },
            { 3, 3, 3, 4, 4, 4, 5, 5, 5 },
            { 3, 3, 3, 4, 4, 4, 5, 5, 5 },
            { 6, 6, 6, 7, 7, 7, 8, 8, 8 },
            { 6, 6, 6, 7, 7, 7, 8, 8, 8 },
            { 6, 6, 6, 7, 7, 7, 8, 8, 8 }
    };

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int matrix[][] = new int[MATRIX_SIZE][MATRIX_SIZE];

        for (int k = 0; k < n; k++) {
            fillMatrix(matrix, scanner);
            printLine(String.format("Instancia %d", k + 1));
            if (isSolution(matrix)) {
                printLine("SIM");
            } else {
                printLine("NAO");
            }
            printLine("");
        }

        scanner.close();
    }

    private static void fillMatrix(int matrix[][], Scanner scanner) {
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static boolean isSolution(int matrix[][]) {
        boolean ocurredInSubMatrix[][] = new boolean[MATRIX_SIZE][MATRIX_SIZE];

        for (int row = 0; row < MATRIX_SIZE; row++) {
            boolean ocurredInRow[] = new boolean[MATRIX_SIZE];
            boolean ocurredInColumn[] = new boolean[MATRIX_SIZE];
            for (int column = 0; column < MATRIX_SIZE; column++) {
                int numberMinus1InRow = matrix[row][column] - 1;
                int numberMinus1InColumn = matrix[column][row] - 1;
                ocurredInRow[numberMinus1InRow] = true;
                ocurredInColumn[numberMinus1InColumn] = true;
                ocurredInSubMatrix[SUB_MATRICES[row][column]][numberMinus1InRow] = true;
            }
            for (int numberMinus1 = 0; numberMinus1 < MATRIX_SIZE; numberMinus1++) {
                if (!ocurredInRow[numberMinus1] || !ocurredInColumn[numberMinus1]) {
                    return false;
                }
            }
        }
        for (int subMatrix = 0; subMatrix < MATRIX_SIZE; subMatrix++) {
            for (int numberMinus1 = 0; numberMinus1 < MATRIX_SIZE; numberMinus1++) {
                if (!ocurredInSubMatrix[subMatrix][numberMinus1]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printLine(String message) {
        System.out.println(message);
    }
}