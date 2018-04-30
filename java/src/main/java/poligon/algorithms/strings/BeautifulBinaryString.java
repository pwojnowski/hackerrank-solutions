package poligon.algorithms.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/beautiful-binary-string/problem
 */
public class BeautifulBinaryString {

    static int beautifulBinaryString(String s) {
        if (s.length() < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 2, n = s.length(); i < n; ++i) {
            if (s.charAt(i) == '0' && s.charAt(i - 1) == '1' && s.charAt(i - 2) == '0') {
                ++count;
                i += 2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String b = in.next();
        int result = beautifulBinaryString(b);
        System.out.println(result);
        in.close();
    }
}
