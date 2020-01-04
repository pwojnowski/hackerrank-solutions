package poligon.algorithms.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheLoveLetterMysteryTest {

    @Test
    public void shouldFindDistances() {
        assertEquals(TheLoveLetterMystery.theLoveLetterMystery("abc"), 2);
        assertEquals(TheLoveLetterMystery.theLoveLetterMystery("abcba"), 0);
        assertEquals(TheLoveLetterMystery.theLoveLetterMystery("abcd"), 4);
        assertEquals(TheLoveLetterMystery.theLoveLetterMystery("cba"), 2);
    }
}