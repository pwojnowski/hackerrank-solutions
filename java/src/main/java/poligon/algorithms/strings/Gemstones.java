package poligon.algorithms.strings;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/gem-stones/problem
 */
public class Gemstones {

    static int gemstones(String[] input) {
        Set<Character> gemstones = stringToCharSet(input[0]);

        for (int i = 1; i < input.length; ++i) {
            gemstones.retainAll(stringToCharSet(input[i]));
        }

        return gemstones.size();
    }

    private static Set<Character> stringToCharSet(String s) {
        return s.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.next();
        }
        int result = gemstones(arr);
        System.out.println(result);
    }
}