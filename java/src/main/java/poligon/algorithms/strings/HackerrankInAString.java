package poligon.algorithms.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem
 */
public class HackerrankInAString {

    static String hackerrankInString(String s) {
        char[] expected = "hackerrank".toCharArray();

        for (int si = 0, ei = 0; si < s.length(); ++si) {
            if (expected[ei] == s.charAt(si)) {
                ++ei;
                if (ei == expected.length) {
                    return "YES";
                }
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            String s = in.next();
            String result = hackerrankInString(s);
            System.out.println(result);
        }
        in.close();
    }
}
