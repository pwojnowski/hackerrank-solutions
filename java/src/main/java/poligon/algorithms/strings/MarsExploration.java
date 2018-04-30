package poligon.algorithms.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/mars-exploration/problem
 */
public class MarsExploration {

    static int marsExploration(String s) {
        int diffs = 0;
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) != 'S') diffs++;
            if (s.charAt(i + 1) != 'O') diffs++;
            if (s.charAt(i + 2) != 'S') diffs++;
            i += 3;
        }

        return diffs;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int result = marsExploration(s);
        System.out.println(result);
        in.close();
    }
}
