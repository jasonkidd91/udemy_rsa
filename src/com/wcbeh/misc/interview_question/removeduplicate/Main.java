package com.wcbeh.misc.interview_question.removeduplicate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class Main {

    /**
     * Time Complexity :: O(n)
     * Space Complexity :: O(n)
     * @param list
     * @return
     */
    public static List<Integer> removeDuplicates(List<Integer> list, boolean myOwnAnswer) {
        return new HashSet<>(list).stream().toList();
    }

    /**
     * Time Complexity :: O(n)
     * Space Complexity :: O(n)
     * @param list
     * @return
     */
    public static List<Integer> removeDuplicates(List<Integer> list) {
        if (list == null || list.size() <= 1) return list;
        List<Integer> results = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (Integer i : list) {
            if (map.get(i) == null) {
                results.add(i);
                map.put(i, true);
            }
        }
        return results;
    }


    public static void main(String[] args) {
        List<Integer> myList = List.of(1, 2, 3, 4, 1, 2, 5, 6, 7, 3, 4, 8, 9, 5);
        List<Integer> newList = removeDuplicates(myList);
        System.out.println(newList);

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6, 7, 8, 9]

            (Order may be different as sets are unordered)
        */

    }

}

