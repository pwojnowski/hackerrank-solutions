package poligon.statistics;

import java.util.Arrays;
import java.util.Scanner;

import static poligon.statistics.StatFunctions.*;

public class MeanMedianMode {

    private static final String SAMPLE_INPUT = "10\n" +
            "64630 11735 14216 99233 14470 4978 73429 38120 51135 67060";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] array = readArrayWithSize(scanner);
            Arrays.sort(array);
            System.out.printf("%.1f%n", mean(array));
            System.out.printf("%.1f%n", median(array));
            System.out.println(mode(array));
        }
    }
}
