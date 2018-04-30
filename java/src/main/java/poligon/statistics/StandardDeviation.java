package poligon.statistics;

import java.util.Arrays;
import java.util.Scanner;

import static poligon.statistics.StatFunctions.readArrayWithSize;
import static poligon.statistics.StatFunctions.standardDeviation;

public class StandardDeviation {

    private static final String INPUT = "5\n10 40 30 50 20";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] data = readArrayWithSize(scanner);
            Arrays.sort(data);
            System.out.printf("%.1f%n", standardDeviation(data));
        }
    }
}
