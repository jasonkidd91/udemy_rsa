package com.wcbeh.misc.interview_question.subarraysumwithnegative;

import java.util.HashMap;

public class Main {

    /**
     * Time Complexity :: O(n * m^2)
     * Space Complexity :: O(1)
     * @param nums
     * @param target
     * @return
     */
    private static int[] subarraySum(int[] nums, int target, boolean myOwnAnswer) {
        // check if target has been there without any operation needed
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return new int[]{i, i};
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int [] res = new int[]{i, 0};
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == target) {
                    res[1] = j;
                    return res;
                }
            }
        }

        return new int[0];
    }

    /**
     * https://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/
     * Time Complexity :: O(n)
     * Space Complexity :: O(n)
     * @param nums
     * @param target
     * @return
     */
    private static int[] subarraySum(int[] nums, int target) {
        int sum = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];

            // for case where continuous sum from idx 0 to current idx == target
            if (sum == target) {
                return new int[] {0, i};
            }

            // as the the cumulative sum - target is exists in hashmap,
            // so it mean we can directly ignore whatever previous number from the hashmap index.
            // therefore, there are taking the index start as (hashmap index + 1), end as current index
            if (hashMap.containsKey(sum - target)) {
                return new int[] { hashMap.get(sum - target) + 1, i };
            }

            hashMap.put(sum, i);
        }

        return new int[] { 0, 0};
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int target1 = 9;
        int[] result1 = subarraySum(nums1, target1);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]");

        int[] nums2 = {-1, 2, 3, -4, 5};
        int target2 = 0;
        int[] result2 = subarraySum(nums2, target2);
        System.out.println("[" + result2[0] + ", " + result2[1] + "]");

        int[] nums3 = {2, 3, 4, 5, 6};
        int target3 = 3;
        int[] result3 = subarraySum(nums3, target3);
        System.out.println("[" + result3[0] + ", " + result3[1] + "]");

        int[] nums4 = {};
        int target4 = 0;
        int[] result4 = subarraySum(nums4, target4);
        System.out.println("[]");

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 3]
            [0, 3]
            [1, 1]
            []

        */

    }

}

