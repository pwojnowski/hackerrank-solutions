package poligon.algorithms.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunnyStringTest {

    @Test
    public void shouldDetermineFunnyStrings() {
        assertEquals("Funny", FunnyString.funnyString("acxz"));
        assertEquals("Not Funny", FunnyString.funnyString("bcxz"));
    }
}