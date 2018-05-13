package poligon.algorithms.strings;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class StrongPassword {

    private static final Set<Character> numbers = getChars("0123456789");
    private static final Set<Character> lower_case = getChars("abcdefghijklmnopqrstuvwxyz");
    private static final Set<Character> upper_case = getChars("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    private static final Set<Character> special_characters = getChars("!@#$%^&*()-+");

    private static Set<Character> getChars(String s) {
        return s.chars().mapToObj(c -> (char) c).collect(toSet());
    }

    static int minimumNumber(int n, String password) {
        Set<Character> chars = getChars(password);
        int missing = 0;
        if (chars.stream().noneMatch(numbers::contains)) {
            ++missing;
        }
        if (chars.stream().noneMatch(lower_case::contains)) {
            ++missing;
        }
        if (chars.stream().noneMatch(upper_case::contains)) {
            ++missing;
        }
        if (chars.stream().noneMatch(special_characters::contains)) {
            ++missing;
        }
        return Math.max(6 - password.length(), missing);
    }
}
