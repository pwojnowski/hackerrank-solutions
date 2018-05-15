package poligon.algorithms.strings;

import org.junit.Test;

import static org.junit.Assert.*;
import static poligon.algorithms.strings.PalindromeIndex.palindromeIndex;

public class PalindromeIndexTest {

    @Test
    public void shouldFindPalindromeIndex() {
        assertEquals(3, palindromeIndex("aaab"));
        assertEquals(0, palindromeIndex("baa"));
        assertEquals(-1, palindromeIndex("aaa"));
    }
}