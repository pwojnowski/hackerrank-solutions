package poligon.algorithms.strings;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

/**
 * https://www.hackerrank.com/challenges/ctci-ransom-note/problem
 */
public class RansomNote {

    public static void main(String[] args) {
        List<String> magazine = toList("give me one grand today night");
        List<String> note = toList("give one grand today");
//        var magazine = toList("attack at down");
//        var note = toList("attack at down");
        String result = checkMagazine(magazine, note);
        System.out.println(result);
    }

    private static String checkMagazine(List<String> magazine, List<String> note) {
        Map<String, Integer> freqs = frequencies(magazine);
        for (String s : note) {
            int old = freqs.getOrDefault(s, 0);
            if (old == 0) {
                return "No";
            }
            freqs.replace(s, old - 1);
        }
        return "Yes";
    }

    private static Map<String, Integer> frequencies(List<String> strings) {
        return strings.stream().collect(toMap(identity(), v -> 1, Integer::sum));
    }

    private static List<String> toList(String s) {
        return Arrays.stream(s.split("\\s+")).collect(Collectors.toList());
    }
}
