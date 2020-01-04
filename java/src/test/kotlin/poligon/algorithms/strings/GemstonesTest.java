package poligon.algorithms.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GemstonesTest {

    @Test
    public void shouldCountGemstones() {
        String[] input = {"abcdde", "baccd", "eeabg"};

        assertEquals(2, Gemstones.gemstones(input));
    }
}