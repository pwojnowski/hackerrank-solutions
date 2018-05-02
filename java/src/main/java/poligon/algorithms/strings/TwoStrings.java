package poligon.algorithms.strings;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/two-strings/problem
 */
public class TwoStrings {

    static String twoStrings(String s1, String s2) {
        Set<Character> chars1 = stringToCharSet(s1);
        Set<Character> chars2 = stringToCharSet(s2);

        chars1.retainAll(chars2);

        return chars1.size() > 0 ? "YES" : "NO";
    }

    private static Set<Character> stringToCharSet(String s) {
        return s.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
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