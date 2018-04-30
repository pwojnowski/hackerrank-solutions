package poligon.algorithms.strings;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/funny-string/problem
 */
public class FunnyString {

    static String funnyString(String s) {
        char[] chars = s.toCharArray();
        int half = chars.length / 2;
        if (half == 0) {
            return "Funny";
        }
        for (int i = 0, j = chars.length - 1; i < half; ++i, --j) {
            if (Math.abs(chars[i] - chars[i + 1]) != Math.abs(chars[j] - chars[j - 1])) {
                return "Not Funny";
            }
        }
        return "Funny";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            String s = in.next();
            String result = funnyString(s);
            System.out.println(result);
        }
    }
}
