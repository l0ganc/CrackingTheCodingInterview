package ArraysAndStrings;

/**
 * Method1: use hash table to count how many times each character appears.
 * Then, we iterate through the hash table and ensure that no more
 * than one character has an odd(奇偶的）count
 */
/**
public class PalindromePermutation_1_4 {
    private static boolean isPermutationOfPalindrome(String phrase) {
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    private static int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }
        return table;
    }

    // Mapping a -> 0,  b -> 1, c -> 2 ......
    // This is case insensitive. Non-letter characters map to -1
    private static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }


    private static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }

        }
        return true;
    }
    public static void main(String[] args) {
        String pali = "Rats live on evil star";
        System.out.println(isPermutationOfPalindrome(pali));
    }
}
/*


/**
 * Method 2
 * Instead of checking the number of odd counts at the end,
 * we can check as we go along.
 * Then, as soon as we get to the end, we have our answer
 */
public class PalindromePermutation_1_4 {
    private static boolean isPermutationOfPalindrome(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
                if (table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;

    }


    /* Mapping a -> 0,  b -> 1, c -> 2 ...... */
    /* This is case insensitive. Non-letter characters map to -1*/
    private static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    public static void main(String[] args) {
        String pali = "Rats live on evil star";
        System.out.println(isPermutationOfPalindrome(pali));
    }
}