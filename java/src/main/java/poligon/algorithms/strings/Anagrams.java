package poligon.algorithms.strings;

import java.util.*;

public class Anagrams {

    static int anagram(String s) {
        if (s.length() % 2 == 1) {
            return -1;
        }
        char[] s1 = s.substring(0, s.length() / 2).toCharArray();
        char[] s2 = s.substring(s.length() / 2).toCharArray();

        Arrays.sort(s1);
        Arrays.sort(s2);

        int diffs = 0;
        int i = 0, j = 0;
        while (i < s1.length && j < s2.length) {
            if (s1[i] < s2[j]) {
                ++diffs;
                ++i;
            } else if (s1[i] > s2[j]) {
                ++diffs;
                ++j;
            } else {
                ++i;
                ++j;
            }
        }

        diffs += Math.abs(i - j);

        return diffs/2;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int q = in.nextInt();
//        for (int a0 = 0; a0 < q; a0++) {
//            String s = in.next();
//            int result = anagram(s);
//            System.out.println(result);
//        }

        System.out.println(anagram("ab"));
    }
}
