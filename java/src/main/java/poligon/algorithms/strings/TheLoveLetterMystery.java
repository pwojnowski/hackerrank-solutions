package poligon.algorithms.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/the-love-letter-mystery/problem
 */
public class TheLoveLetterMystery {

    static int theLoveLetterMystery(String s) {
        char[] chars = s.toCharArray();
        int dist = 0;

        for (int i = 0, j = chars.length-1, half = chars.length/2; i < half; ++i, --j) {
            dist += Math.abs(chars[i] - chars[j]);
        }

        return dist;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            String s = in.next();
            int result = theLoveLetterMystery(s);
            System.out.println(result);
        }
    }
}
