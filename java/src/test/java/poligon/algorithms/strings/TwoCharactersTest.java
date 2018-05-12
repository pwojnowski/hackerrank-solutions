package poligon.algorithms.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoCharactersTest {

    @Test
    public void shouldFindTwoAlternatingChars() {
        assertEquals(5, TwoCharacters.twoCharacters("beabeefeab"));
        assertEquals(8, TwoCharacters.twoCharacters("cwomzxmuelmangtosqkgfdqvkzdnxerhravxndvomhbokqmvsfcaddgxgwtpgpqrmeoxvkkjunkbjeyteccpugbkvhljxsshpoymkryydtmfhaogepvbwmypeiqumcibjskmsrpllgbvc"));
    }

    @Test
    public void shouldFindNoAlternatingChars() {
        assertEquals(0, TwoCharacters.twoCharacters("aabb"));
    }
}