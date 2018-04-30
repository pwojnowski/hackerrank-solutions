package poligon.algorithms.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/string-construction/problem
 */
public class StringConstruction {

    static int stringConstruction(String s) {
        boolean[] costs = new boolean[26];

        for (char c : s.toCharArray()) {
            costs[c - 'a'] = true;
        }

        int cost = 0;
        for (boolean b : costs) {
            if (b) {
                ++cost;
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            String s = in.next();
            int result = stringConstruction(s);
            System.out.println(result);
        }
        in.close();
    }
}