package poligon.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/countingsort4/problem
 */
public class FullCountingSort {

    public static String sort(Object[][] lines) {
        obfuscateFirstHalf(lines);

        List<String>[] sorted = countingSort(lines);

        System.out.println("Sorted: " + Arrays.toString(sorted));

        return formatResult(sorted);
    }

    private static List<String>[] countingSort(Object[][] lines) {
        List<String>[] sorted = new List[100];
        for (int i = 0; i < lines.length; ++i) {
            if (sorted[(int) lines[i][0]] == null) {
                sorted[(int) lines[i][0]] = new ArrayList<>();
            }
            sorted[(int) lines[i][0]].add((String) lines[i][1]);
        }
        return sorted;
    }

    private static String formatResult(List<String>[] lines) {
        return Arrays.stream(lines).filter(Objects::nonNull).flatMap(List::stream).collect(Collectors.joining(" "));
    }

    private static void obfuscateFirstHalf(Object[][] lines) {
        for (int i = 0, n = lines.length/2; i < n; ++i) {
            lines[i][1] = "-";
        }
    }
}
