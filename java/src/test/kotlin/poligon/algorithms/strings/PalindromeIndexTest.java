package poligon.algorithms.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static poligon.algorithms.strings.PalindromeIndex.palindromeIndex;

public class PalindromeIndexTest {

    @Test
    public void shouldFindPalindromeIndex() {
        assertEquals(3, palindromeIndex("aaab"));
        assertEquals(0, palindromeIndex("baa"));
        assertEquals(-1, palindromeIndex("aaa"));
    }
}