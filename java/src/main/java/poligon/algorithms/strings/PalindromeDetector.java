package poligon.algorithms.strings;

public class PalindromeDetector {

    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length()-1; i <= j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public boolean isSlowPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
