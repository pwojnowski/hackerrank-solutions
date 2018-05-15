package poligon.algorithms.strings;

/**
 * https://www.hackerrank.com/challenges/palindrome-index/problem
 */
public class PalindromeIndex {

    static int palindromeIndex(String s) {
        int miss = checkPalindrome(s);
        if (miss != -1) {
            String v1 = s.substring(0, miss).concat(s.substring(miss + 1));
            if (checkPalindrome(v1) == -1) {
                return miss;
            }
            miss = s.length() - 1 - miss;
            v1 = s.substring(0, miss).concat(s.substring(miss + 1));
            if (checkPalindrome(v1) == -1) {
                return miss;
            }
            return -1;
        }
        return miss;
    }

    private static int checkPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return i;
            }
        }
        return -1;
    }
}
