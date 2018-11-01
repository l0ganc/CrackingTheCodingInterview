package ArraysAndStrings;

/**
 * Method 1
 * We can go ahead and implement this algorithm now.
 * We'll merge the insertion and removal check into one stem
 * and check the replacement step separately
 */
/**
public class OneWay_1_5 {
    private static boolean onewEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        } else if (first.length() - 1 == second.length()) {
            return oneEditInsert(second, first);
        }
        return false;
    }

    private static boolean oneEditInsert(String first, String second) {
        int index1 = 0;
        int index2 = 0;

        while (index1 < first.length() && index2 < second.length()) {
            if (first.charAt(index1) != second.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    private static boolean oneEditReplace(String first, String second) {
        boolean foundDifference = false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String a = "pse";
        String b = "pale";
        boolean isOneEdit = onewEditAway(a, b);
        System.out.println(isOneEdit);
    }
}
 */

/**
 * Method 2
 * merge the oneEditInsert and oneEditReplace into one method
 * because they are nearly the same
 */

public class OneWay_1_5 {
    public static boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        String s1 = first.length() > second.length() ? second : first;
        String s2 = second.length() > first.length() ? second : first;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
                if (s1.length() == s2.length()) {
                    index1++;
                }
            } else {
                index1++;
            }
            index2++;
        }
        return  true;
    }


    public static void main(String[] args) {
        String a = "palee";
        String b = "pale";
        boolean isOneEdit1 = oneEditAway(a, b);
        System.out.println(a + ", " + b + ": " + isOneEdit1);

        String c = "pale";
        String d = "pkle";
        boolean isOneEdit2 = oneEditAway(c, d);
        System.out.println(c + ", " + d + ": " + isOneEdit2);
    }
}
