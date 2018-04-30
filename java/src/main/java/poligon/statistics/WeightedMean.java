package poligon.statistics;

import java.util.Scanner;

public class WeightedMean {

    private static final String INPUT =
            "5\n" +
            "10 40 30 50 20\n" +
            "1 2 3 4 5";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int size = scanner.nextInt();
            int[] values = readArray(scanner, size);
            int[] weights = readArray(scanner, size);
            System.out.printf("%.1f%n", weightedMean(values, weights));
        }
    }

    private static double weightedMean(int[] values, int[] weights) {
        for (int i = 0; i < values.length; ++i) {
            values[i] *= weights[i];
        }
        return (double) sum(values)/sum(weights);
    }

    private static int[] readArray(Scanner scanner, int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; ++i) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    private static int sum(int[] values) {
        int sum = 0;
        for (int val : values) {
            sum += val;
        }
        return sum;
    }
}
