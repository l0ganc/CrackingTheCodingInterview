package ArraysAndStrings;

/**
 * Method 1
 * using string
 * is a bad idea because every time we do concatenation operations, we need to copy
 * the whole string and copy again and again. This leads to 0(n^2)
 *
 */
/**
public class StringCompression_1_6 {

    private static String CompressBad(String str) {
        String res = "";
        int tempCount = 0;
        for (int i = 0; i < str.length(); i++) {
            tempCount++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                res += "" + str.charAt(i) + tempCount;
                tempCount = 0;
            }
        }
        return res.length() < str.length() ? res : str;
    }


    public static void main(String[] args) {
        String str = "aabcccccaaa";
        System.out.println(CompressBad(str));
    }

}
*/


/**
 * Method 2 : Using StringBuilder
 */
public class StringCompression_1_6 {

    private static String CompressBad(String str) {
        StringBuilder res = new StringBuilder();
        int tempCount = 0;
        for (int i = 0; i < str.length(); i++) {
            tempCount++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                res.append(str.charAt(i));
                res.append(tempCount);
                tempCount = 0;
            }
        }
        return res.length() < str.length() ? res.toString() : str;
    }


    public static void main(String[] args) {
        String str = "aabcccccaaa";
        System.out.println(CompressBad(str));
    }

}

