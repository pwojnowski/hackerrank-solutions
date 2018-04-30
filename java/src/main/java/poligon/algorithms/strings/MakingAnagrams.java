package poligon.algorithms.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/making-anagrams/problem
 */
public class MakingAnagrams {

    static int makingAnagrams(String s1, String s2) {
        char[] chars = new char[26];

        for (int i = 0; i < s1.length(); ++i) {
            ++chars[s1.charAt(i) - 'a'];
        }
        for (int i = 0; i < s2.length(); ++i) {
            --chars[s2.charAt(i) - 'a'];
        }

        int diffs = 0;
        for (char c : chars) {
            diffs += Math.abs(c);
        }

        return diffs;
    }

    static int makingAnagramsSlow(String s1, String s2) {
        char[] chars1 = new char[26];
        char[] chars2 = new char[26];

        for (int i = 0; i < s1.length(); ++i) {
            chars1[s1.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < s2.length(); ++i) {
            chars2[s2.charAt(i) - 'a'] += 1;
        }

        int diffs = 0;
        for (int i = 0; i < chars1.length; ++i) {
            if (chars1[i] != chars2[i]) {
                diffs += Math.abs(chars1[i] - chars2[i]);
            }
        }
        return diffs;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = makingAnagramsSlow(s1, s2);
        System.out.println(result);
    }
}