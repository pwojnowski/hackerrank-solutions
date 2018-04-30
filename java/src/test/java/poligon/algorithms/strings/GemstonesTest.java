package poligon.algorithms.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class GemstonesTest {

    @Test
    public void shouldCountGemstones() {
        String[] input = {"abcdde", "baccd", "eeabg"};

        assertEquals(2, Gemstones.gemstones(input));
    }
}