package poligon.algorithms.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class CaesarCipherTest {

    private CaesarCipher caesar = new CaesarCipher();

    @Test
    public void shouldDoNothingWithEmptyString() {
        assertEquals("", caesar.cipher("", 3));
    }

    @Test
    public void shouldNotCipherSymbols() {
        assertEquals("-", caesar.cipher("-", 3));

        String symbols = "1!@#$%^&*(){}/";
        assertEquals(symbols, caesar.cipher(symbols, 3));
    }

    @Test
    public void shouldCipherLowerCaseLetter() {
        assertEquals("a", caesar.cipher("a", 0));

        assertEquals("b", caesar.cipher("a", 1));
        assertEquals("d", caesar.cipher("a", 3));
        assertEquals("j", caesar.cipher("e", 5));

        assertEquals("a", caesar.cipher("z", 1));
        assertEquals("c", caesar.cipher("x", 5));
    }

    @Test
    public void shouldCipherUpperCaseLetter() {
        assertEquals("A", caesar.cipher("A", 0));

        assertEquals("B", caesar.cipher("A", 1));
        assertEquals("D", caesar.cipher("A", 3));
        assertEquals("J", caesar.cipher("E", 5));

        assertEquals("A", caesar.cipher("Z", 1));
        assertEquals("C", caesar.cipher("X", 5));
        assertEquals("Z", caesar.cipher("C", -3));
    }

    @Test
    public void shouldCipherWholeAlphabet() {
        String allChars = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
        assertEquals("QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD", caesar.cipher(allChars, -3));
    }

    @Test
    public void shouldCycle() {
        assertEquals("aoeu-snth", caesar.cipher("aoeu-snth", 52));
        assertEquals("cqgw-upvj", caesar.cipher("aoeu-snth", 54));
    }

    @Test
    public void shouldDecipher() {
        String s = "aoeu";

        String encrypted = caesar.cipher(s, 2);

        assertEquals(s, caesar.cipher(encrypted, -2));
    }
}