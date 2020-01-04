package poligon.algorithms.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static poligon.algorithms.strings.SeparateNumbers.separateNumbers;

public class SeparateNumbersTest {

    @Test
    public void shouldFindBeautifulNumbers() {
        assertEquals("YES 1", separateNumbers("1234"));
        assertEquals("YES 9", separateNumbers("91011"));
        assertEquals("YES 99", separateNumbers("99100"));
        assertEquals("NO", separateNumbers("101103"));
        assertEquals("NO", separateNumbers("010203"));
        assertEquals("NO", separateNumbers("13"));
        assertEquals("NO", separateNumbers("1"));
        assertEquals("NO", separateNumbers("10203"));
        assertEquals("NO", separateNumbers("312"));
    }

}