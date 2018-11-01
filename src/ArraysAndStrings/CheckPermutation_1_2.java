package ArraysAndStrings;

/**
 * Given two strings, write a method to decide if one is permutation of the other
 */

import java.util.Arrays;

/**
 * two methods;
 * method 1: sort the array and compare each other
 * method 2: Check if the two strings have identical character counts
 */

/**
public class CheckPermutation_1_2 {
    public static String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public static boolean isPermutation(String s1, String s2) {
        return sort(s1).equals(sort(s2));
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean result = isPermutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + result);
        }
    }
}

 */

/**
 * method 2: Check if the two strings have identical character counts
 */
public class CheckPermutation_1_2 {
    private static boolean isPermutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[128];   // Assumption: ASCII
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            letters[t.charAt(i)]--;
            if (letters[t.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean result = isPermutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + result);
        }
    }
}
