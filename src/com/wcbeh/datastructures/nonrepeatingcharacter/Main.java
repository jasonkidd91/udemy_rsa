package com.wcbeh.datastructures.nonrepeatingcharacter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    /**
     * Time Complexity :: O(n)
     * Space Complexity :: O(256)
     * @param str
     * @return
     */
    public static Character firstNonRepeatingChar(String str) {
        // character max limit is 256, initiate all character with default value 0
        int[] store = new int[256];
        for (char ch : str.toCharArray()) {
            store[ch]++;
        }

        for (char ch : str.toCharArray()) {
            if (store[ch] == 1) {
                return ch;
            }
        }

        return null;
    }

    /**
     * https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/
     * Time Complexity :: O(n^2)
     * Space Complexity :: O(1)
     * @param str
     * @return
     */
    public static Character firstNonRepeatingChar(String str, String anotherAnswer) {
        for (char ch : str.toCharArray()) {
            if (str.indexOf(ch) == str.lastIndexOf(ch)) {
                return ch;
            }
        }
        return null;
    }

    /**
     * Time Complexity :: O(n)
     * Space Complexity :: O(n)
     * @param str
     * @return
     */
    public static Character firstNonRepeatingChar(String str, boolean myOwnAnswer) {
        // linkedHashMap will remember the input order
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (Character c : str.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingChar("leetcode"));
        System.out.println(firstNonRepeatingChar("hello"));
        System.out.println(firstNonRepeatingChar("aabbcc"));

        /*
            EXPECTED OUTPUT:
            ----------------
            l
            h
            null

        */

    }

}

