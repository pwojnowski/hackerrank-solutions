package poligon.algorithms.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeDetectorTest {

    private PalindromeDetector detector = new PalindromeDetector();

    @Test
    public void shouldFindPalindromes() {
        assertTrue(detector.isPalindrome(""));
        assertTrue(detector.isPalindrome("a"));
        assertTrue(detector.isPalindrome("aba"));
        assertTrue(detector.isPalindrome("abba"));
        assertTrue(detector.isPalindrome("madamimadam"));

        assertTrue(detector.isSlowPalindrome("madamimadam"));
    }

    @Test
    public void shouldDetectNotPalindromes() {
        assertFalse(detector.isPalindrome("ab"));
        assertFalse(detector.isPalindrome("abab"));
        assertFalse(detector.isPalindrome("random string"));

        assertFalse(detector.isSlowPalindrome("random string"));
    }
}
