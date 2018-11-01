package ArraysAndStrings;


// implement an algorithm to determine if a string has all unique characters.
// What if you cannot use additional data structures?

// 法一
// time complexity: O (n)
// space complexity: O (1)
/**
public class IsUnique_1_1 {
    public static boolean isUnique(String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "asdad", "qwerdf", "safsdfsf"};
        for (String word : words) {
            System.out.println(word + ": " + isUnique(word));
        }
    }
}
*/



/* 法二 */
public class IsUnique_1_1 {
    public static boolean isUnique(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(1 << 8);
        String[] words = {"abcde", "asdad", "qwerdf", "safsdfsf"};
        for (String word : words) {
            System.out.println(word + ": " + isUnique(word));
        }
    }
}