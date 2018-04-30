package poligon.algorithms.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class FunnyStringTest {

    @Test
    public void shouldDetermineFunnyStrings() {
        assertEquals("Funny", FunnyString.funnyString("acxz"));
        assertEquals("Not Funny", FunnyString.funnyString("bcxz"));
    }
}