import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        double salary = scanner.nextDouble();

        printTaxes(calculateTaxes(salary));

        scanner.close();
    }

    final static double SALARY_LIMITS[] = { 2000, 3000, 4500 };
    final static double TAX_PERCENTAGES[] = { .08, .18, .28 };

    private static double calculateTaxes(double salary) {
        double amountsToApplyTaxes[] = { 0, 0, 0 };
        double taxes = 0;

        calculateDifferenceBetweenSalaryAndSalaryLimits(salary, amountsToApplyTaxes);
        subtractDuplicatedDifferencesBetweenSalaryAndSalaryLimits(amountsToApplyTaxes);

        for (int i = 0; i < TAX_PERCENTAGES.length; i++) {
            taxes += TAX_PERCENTAGES[i] * amountsToApplyTaxes[i];
        }

        return taxes;
    }

    private static void calculateDifferenceBetweenSalaryAndSalaryLimits(double salary, double amountsToApplyTaxes[]) {
        for (int i = 0; i < SALARY_LIMITS.length; i++) {
            if (salary <= SALARY_LIMITS[i])
                continue;
            amountsToApplyTaxes[i] = salary - SALARY_LIMITS[i];
        }
    }

    private static void subtractDuplicatedDifferencesBetweenSalaryAndSalaryLimits(double amountsToApplyTaxes[]) {
        for (int i = amountsToApplyTaxes.length - 2; i >= 0; i--) {
            for (int j = amountsToApplyTaxes.length - 1; j > i; j--) {
                amountsToApplyTaxes[i] -= amountsToApplyTaxes[j];
            }
        }
    }

    private static void printTaxes(double taxes) {
        if (taxes == 0)
            print("Isento");
        else
            print(String.format("R$ %.2f", taxes));
    }

    private static void print(String message) {
        System.out.println(message);
    }
}