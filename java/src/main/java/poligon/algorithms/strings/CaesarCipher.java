package poligon.algorithms.strings;

import java.util.Scanner;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

public class CaesarCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        int k = scanner.nextInt();

        CaesarCipher caesar = new CaesarCipher();
        System.out.println(caesar.cipher(s, k));
    }

    private static final int ALPHABET_SIZE = 26;

    public String cipher(String message, int rotateBy) {
        // rotate by only the size of the alphabet:
        rotateBy %= ALPHABET_SIZE;
        char[] chars = message.toCharArray();
        rotate(chars, rotateBy);
        return new String(chars);
    }

    private void rotate(char[] chars, int rotateBy) {
        for (int i = 0; i < chars.length; ++i) {
            if (isLowerCase(chars[i])) {
                chars[i] = rotateChar(chars[i], rotateBy, 'a', 'z');
            } else if (isUpperCase(chars[i])) {
                chars[i] = rotateChar(chars[i], rotateBy, 'A', 'Z');
            }
        }
    }

    private char rotateChar(char c, int rotateBy, char firstChar, char lastChar) {
        c += rotateBy;
        if (c < firstChar) {
            return (char) (c + ALPHABET_SIZE);
        }
        if (c > lastChar) {
            return (char) (c - ALPHABET_SIZE);
        }
        return c;
    }
}