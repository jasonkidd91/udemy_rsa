package com.wcbeh.misc.interview_question.twosum;

import java.util.Arrays;
import java.util.HashMap;


public class Main {

    /**
     * Doesn't pass test case if consists of 2 available sum set
     * Time Complexity :: O(n^2)
     * Space Complexity :: O(1)
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum(int[] nums, int target, boolean myOwnAnswer) {
        for (int i = 0; i < nums.length; i++) {
            int balance = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == balance) {
                    return new int[]{ i, j };
                }
            }
        }

        return new int[0];
    }

    /**
     * Won't works the 2 number is not in adjacent
     * Time Complexity :: O(n)
     * Space Complexity :: O(1)
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum(int[] nums, int target, String anotherAnswer) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] + nums[i] == target) {
                return new int[]{ i-1, i };
            }
        }

        return new int[0];
    }

    /**
     * Time Complexity :: O(n)
     * Space Complexity :: O(n)
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int balance = target - nums[i];
            if (map.containsKey(balance)) {
                return new int[] {map.get(balance), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 10)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 3)));
        System.out.println(Arrays.toString(twoSum(new int[]{}, 0)));

        /*
            EXPECTED OUTPUT:
            ----------------
            [0, 1]
            [1, 2]
            [0, 1]
            []
            [2, 3]
            [0, 1]
            []

        */

    }

}

