import java.io.IOException;
import java.util.Scanner;

public class Main {
    final static String NOTES = "WHQESTX";
    final static double DURATIONS[] = { 1., 1. / 2., 1. / 4., 1. / 8., 1. / 16., 1. / 32., 1. / 64. };

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        for (String line = scanner.nextLine(); !line.equals("*"); line = scanner.nextLine()) {
            String measures[] = divideMeasures(line);
            print(String.format("%d", countMeasuresWithCorrectDurations(measures)));
        }

        scanner.close();
    }

    private static String[] divideMeasures(String line) {
        line = line.replaceAll("/", " ");
        line = line.trim();
        return line.split(" ");
    }

    private static int countMeasuresWithCorrectDurations(String measures[]) {
        int measuresWithCorrectDurations = 0;

        for (int i = 0; i < measures.length; i++) {
            double measureDuration = 0;
            for (int j = 0; j < measures[i].length(); j++) {
                measureDuration += DURATIONS[NOTES.indexOf(measures[i].charAt(j))];
            }
            if (measureDuration == 1)
                measuresWithCorrectDurations++;
        }

        return measuresWithCorrectDurations;
    }

    private static void print(String message) {
        System.out.println(message);
    }
}