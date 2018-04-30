package poligon.statistics;

import java.util.Arrays;
import java.util.Scanner;

import static poligon.statistics.StatFunctions.*;

public class Quartiles {

    private static final String SAMPLE = "9\n3 7 8 5 12 14 21 13 18\n";
    private static final String SAMPLE2 = "2\n3 7\n";

    public static void main(String[] args) {
        int[] data = readArrayWithSize(new Scanner(SAMPLE));

        // To find median data has to be sorted.
        Arrays.sort(data);

        // It is guaranteed in the rules that quartiles are integers.
        for (double quartile : quartiles(data)) {
            System.out.println((int) quartile);
        }
    }
}
