package poligon.statistics;

import java.util.Arrays;
import java.util.Scanner;

import static poligon.statistics.StatFunctions.*;

public class InterQuartileRange {

    private static final String SAMPLE
            = "6\n"
            + "6 12 8 10 20 16\n"
            + "5 4 3 2 1 5";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int size = scanner.nextInt();
            int[] values = readArray(scanner, size);
            int[] frequencies = readArray(scanner, size);

            values = generateData(values, frequencies);

            // To find median data has to be sorted.
            Arrays.sort(values);

            double[] quartiles = quartiles(values);
            System.out.println(quartiles[2] - quartiles[0]);
        }
    }

    private static int[] generateData(int[] values, int[] frequencies) {
        int[] data = new int[sum(frequencies)];
        int pos = 0;
        for (int current = 0; current < values.length; ++current) {
            for (int i = 0; i < frequencies[current]; ++i) {
                data[pos++] = values[current];
            }
        }
        return data;
    }
}
