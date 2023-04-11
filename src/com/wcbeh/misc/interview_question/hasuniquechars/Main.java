package com.wcbeh.misc.interview_question.hasuniquechars;

import java.util.HashMap;
import java.util.HashSet;


public class Main {

    /**
     * Time Complexity :: O(n)
     * Space Complexity :: O(n)
     * @param str
     * @return
     */
    public static boolean hasUniqueChars(String str, boolean myOwnAnswer) {
        HashMap<Character, Boolean> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            if (map.containsKey(ch)) {
                return false;
            }
            map.put(ch, true);
        }
        return true;
    }

    /**
     * Time Complexity :: O(n)
     * Space Complexity :: O(256)
     * @param str
     * @return
     */
    public static boolean hasUniqueChars(String str, String anotherAnswer) {
        int[] store = new int[256];
        for (char ch : str.toCharArray()) {
            if (store[ch] != 0) {
                return false;
            }
            store[ch]++;
        }
        return true;
    }

    /**
     * Time Complexity :: O(n log n)
     * Space Complexity :: O(n)
     * @param str
     * @return
     */
    public static boolean hasUniqueChars(String str, Integer thirdAnswer) {
        // convert string to set
        // if set length is equal to str length, mean unique
        HashSet<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            set.add(ch);
        }
        return set.size() == str.length();
    }

    /**
     * https://www.geeksforgeeks.org/determine-string-unique-characters/
     * Time Complexity :: O(n)
     * Space Complexity :: O(1)
     * @param str
     * @return
     */
    public static boolean hasUniqueChars(String str) {
        // Assuming string can have characters a-z
        // this has 32 bits set to 0
        int checker = 0;

        for (int i = 0; i < str.length(); i++) {
            // In the line int bitAtIndex = str.charAt(i) - 'a';
            // the character at index i of the input string str is converted to an integer
            // that represents the position of that character in the alphabet, starting from zero.
            // The character 'a' has a decimal ASCII code of 97, and so the character at index i is
            // subtracted by 'a' in order to get the difference between the ASCII code of the character
            // and the ASCII code of 'a'. This difference gives an integer value that represents the position
            // of the character in the alphabet. For example, if str.charAt(i) returns the character 'c',
            // then str.charAt(i) - 'a' will evaluate to 2, which represents the position of the character 'c'
            // in the alphabet (counting from zero, where 'a' is the 0th letter).
            int bitAtIndex = str.charAt(i) - 'a'; // will get a = 0, b = 1, c = 2, .... z = 25

            // if that bit is already set in checker,
            // return false
            if ((checker & (1 << bitAtIndex)) > 0)
                return false;

            // otherwise update and continue by
            // setting that bit in the checker
            checker = checker | (1 << bitAtIndex);
            System.out.println(checker);
        }

        // no duplicates encountered, return true
        return true;
    }

    public static void main(String[] args) {
        System.out.println(hasUniqueChars("abcdefg")); // should return true
        System.out.println(hasUniqueChars("hello")); // should return false
        System.out.println(hasUniqueChars("")); // should return true
        System.out.println(hasUniqueChars("0123456789")); // should return true
        System.out.println(hasUniqueChars("abacadaeaf")); // should return false

        /*
            EXPECTED OUTPUT:
            ----------------
            true
            false
            true
            true
            false

        */

    }

}

