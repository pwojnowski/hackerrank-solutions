package poligon.algorithms.strings;

/**
 * https://www.hackerrank.com/challenges/separate-the-numbers/problem
 */
public class SeparateNumbers {

    static String separateNumbers(String s) {
        for (int numSize = 1, n = s.length() / 2; numSize <= n; ++numSize) {
            long firstNumber = firstNumber(s, numSize);
            int pos = matchNumbers(s, firstNumber, numSize);
            if (pos == s.length()) {
                return "YES " + firstNumber;
            }
        }
        return "NO";
    }

    private static int matchNumbers(String s, long firstNumber, int pos) {
        long currentNumber = firstNumber;
        do {
            String next = Long.toString(++currentNumber);
            if (isExpectedNumber(s, pos, next)) {
                pos += next.length();
            } else {
                break;
            }
        } while (pos < s.length());
        return pos;
    }

    private static long firstNumber(String number, int size) {
        return Long.valueOf(number.substring(0, size));
    }

    private static boolean isExpectedNumber(String s, int pos, String expectedNumber) {
        return s.regionMatches(pos, expectedNumber, 0, expectedNumber.length());
    }
}
