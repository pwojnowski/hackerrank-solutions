package poligon.algorithms.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/weighted-uniform-string/problem
 */
public class WeightedUniformStrings {

    static String[] weightedUniformStrings(String s, int[] queries) {
        String[] answers = new String[queries.length];

        Set<Integer> weights = new HashSet<>();

        char prev = 0;
        int times = 1;

        for (char c : s.toCharArray()) {
            int weight = c - 'a' + 1;
            weights.add(weight);
            if (c == prev) {
                ++times;
                weights.add(weight*times);
            } else {
                prev = c;
                times = 1;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int w = queries[i];
            answers[i] = weights.contains(w) ? "Yes" : "No";
        }

        return answers;
    }
}
