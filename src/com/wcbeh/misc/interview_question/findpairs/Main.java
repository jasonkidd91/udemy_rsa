package com.wcbeh.misc.interview_question.findpairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Main {

    /**
     * Time Complexity :: O(n^2)
     * Space Complexity :: O(1)
     * @param arr1
     * @param arr2
     * @param target
     * @return
     */
    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target, boolean myOwnAnswer) {
        List<int[]> results = new ArrayList<>();
        for (int i : arr1) {
            for (int j : arr2) {
                if ((i + j) == target) {
                    results.add(new int[] {i, j});
                }
            }
        }
        return results;
    }

    /**
     * Two Pointer Method
     * Time Complexity :: O(n*m)
     * Space Complexity :: O(1)
     * @param arr1
     * @param arr2
     * @param target
     * @return
     */
    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
        List<int[]> results = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < arr1.length) {
            int num1 = arr1[i];
            int num2 = arr2[j];
            if (num1 + num2 == target) {
                results.add(new int[]{ num1, num2 });
            }

            if (j + 1 >= arr2.length) {
                // j has reach end
                // increase i pointer by 1 and reset j pointer to 0
                i++;
                j = 0;
            } else {
                j++;
            }
        }

        Collections.reverse(results);
        return results;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 4, 6, 8, 10};
        int target = 7;

        List<int[]> pairs = findPairs(arr1, arr2, target);
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }

        /*
            EXPECTED OUTPUT:
            ----------------
            [5, 2]
            [3, 4]
            [1, 6]

        */

    }

}


