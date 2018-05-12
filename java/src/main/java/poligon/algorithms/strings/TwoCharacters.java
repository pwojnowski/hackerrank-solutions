package poligon.algorithms.strings;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

/**
 * https://www.hackerrank.com/challenges/two-characters/problem
 */
public class TwoCharacters {

    static int twoCharacters(String s) {
        List<Entry<Character, Integer>> frequencies = frequencies(s);

        int longest = 0;
        if (frequencies.size() >= 2) {
            char[] chars = s.toCharArray();

            for (int i = 0; i < frequencies.size() - 1; ++i) {
                Entry<Character, Integer> c1 = frequencies.get(i);
                for (int j = i+1; j < frequencies.size(); ++j) {
                    Entry<Character, Integer> c2 = frequencies.get(j);
                    if (isValid(chars, c1.getKey(), c2.getKey())) {
                        longest = Math.max(longest, c1.getValue() + c2.getValue());
                    }
                }
            }
        }
        return longest;
    }

    private static boolean isValid(char[] chars, char c1, char c2) {
        int i = 0;
        while (chars[i] != c1 && chars[i] != c2) {
            ++i;
        }

        char current = chars[i++];
        char expected = (current == c1) ? c2 : c1;

        do {
            if (chars[i] == current || chars[i] == expected) {
                if (chars[i] == current) {
                    return false;
                }
                char tmp = current;
                current = expected;
                expected = tmp;
            }
            ++i;
        } while (i < chars.length);
        return true;
    }

    private static List<Entry<Character, Integer>> frequencies(String s) {
        Map<Character, Integer> freqs = new HashMap<>();
        s.chars().forEach(c -> freqs.merge((char) c, 1, Integer::sum));

        List<Entry<Character, Integer>> entries = new ArrayList<>();
        freqs.forEach((key, value) -> entries.add(new SimpleEntry<>(key, value)));

        return entries;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        String s = in.next();
        int result = twoCharacters(s);
        System.out.println(result);
        in.close();
    }
}