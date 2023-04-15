import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int currentFollowers = scanner.nextInt();
        int minimumFollowersToAssociateToPlatform = scanner.nextInt();
        Queue<Integer> subscribersPerDay = new LinkedList<>();
        while (scanner.hasNextInt()) {
            subscribersPerDay.add(scanner.nextInt());
        }
        int daysToBeAbleToAssocieteToPlatform = 0;
        while (currentFollowers < minimumFollowersToAssociateToPlatform) {
            int averageSubscribersCeiling = calculateCeilfAverageOfQueue(subscribersPerDay);
            currentFollowers += averageSubscribersCeiling;
            daysToBeAbleToAssocieteToPlatform++;
            subscribersPerDay.remove();
            subscribersPerDay.add(averageSubscribersCeiling);
        }
        System.out.println(daysToBeAbleToAssocieteToPlatform);

        scanner.close();
    }

    static int calculateCeilfAverageOfQueue(Queue<Integer> queue) {
        return (int) Math.ceil(
                queue.stream()
                        .mapToDouble(v -> v)
                        .average()
                        .getAsDouble());
    }
}