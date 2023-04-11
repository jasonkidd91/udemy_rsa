package com.wcbeh.misc.interview_question.groupanagrams;

import java.util.*;

public class Main {

    /**
     * Time Complexity :: O(N x M x logM + N)
     * Space Complexity :: O(M x N)
     * @param strings
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strings, boolean myOwnAnswer) {
        List<List<String>> results = new ArrayList<>();

        Map<String, List<String>> map = new LinkedHashMap<>();
        for (String string : strings) {
            char[] current = string.toCharArray();
            Arrays.sort(current);
            String key = new String(current);
            if (map.get(key) != null) {
                map.get(key).add(string);
            } else {
                // The Arrays.asList || Collections.singletonList method returns an immutable list containing
                // only the specified object. In the code above, the method is being used to add a new value
                // to a list in the map variable. However, since the returned list is immutable,
                // an UnsupportedOperationException will be thrown when trying to modify it later.
                map.put(key, new ArrayList<>(Collections.singletonList(string)));
            }
        }

        map.forEach((k, v) -> results.add(v));
        return results;
    }

    /**
     * Time Complexity :: O(NM)
     * Space Complexity :: O(NM)
     * @param strings
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strings) {
        List<List<String>> results = new ArrayList<>();

        // Inner hashmap counts frequency of characters in a string.
        // Outer hashmap for if same frequency characters are present in
        //   in a string then it will add it to the arraylist.
        HashMap< HashMap<Character, Integer>, ArrayList<String> > map = new LinkedHashMap<>();
        for (String string : strings) {

            // get all character frequency
            HashMap<Character, Integer> tempMap = new HashMap<>();
            for (int i = 0; i < string.length(); i++) {
                tempMap.merge(string.charAt(i), 1, Integer::sum);
            }

            // if same frequency exists, then append the string
            // else add into outer map with value of list(current string)
            if (map.get(tempMap) != null) {
                map.get(tempMap).add(string);
            } else {
                map.put(tempMap, new ArrayList<>(Collections.singletonList(string)));
            }
        }

        map.forEach((k, v) -> results.add(v));
        return results;
    }


    public static void main(String[] args) {
        System.out.println("1st set:");
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        System.out.println("\n2nd set:");
        System.out.println(groupAnagrams(new String[]{"abc", "cba", "bac", "foo", "bar"}));

        System.out.println("\n3rd set:");
        System.out.println(groupAnagrams(new String[]{"listen", "silent", "triangle", "integral", "garden", "ranged"}));

        /*
            EXPECTED OUTPUT:
            ----------------
            1st set:
            [[eat, tea, ate], [tan, nat], [bat]]

            2nd set:
            [[abc, cba, bac], [foo], [bar]]

            3rd set:
            [[listen, silent], [triangle, integral], [garden, ranged]]

        */

    }

}
