package poligon.algorithms.strings;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://www.hackerrank.com/challenges/two-strings/problem
 */
public class TwoStrings {

    static String twoStrings(String s1, String s2) {
        Set<Character> chars = toCharStream(s1).collect(Collectors.toSet());
        return toCharStream(s2).anyMatch(chars::contains) ? "YES" : "NO";
    }

    private static Stream<Character> toCharStream(String s) {
        return s.chars().mapToObj(c -> (char) c);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int arr_i = 0; arr_i < n; arr_i += 2) {
            String s1 = in.next();
            String s2 = in.next();
            String result = twoStrings(s1, s2);
            System.out.println(result);
        }
    }
}