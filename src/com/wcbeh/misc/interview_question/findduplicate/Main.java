package com.wcbeh.misc.interview_question.findduplicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Main {

    /**
     * https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
     * Time Complexity :: O(n)
     * Space Complexity :: O(1)
     * @param nums
     * @return
     */
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> results = new ArrayList<>();
        // for every value traverse, add it with nums.length
        // the % nums.length is used in order to retrive back the original value without adding of nums.length
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i] % nums.length);
            nums[nums[i] % nums.length]
                    = nums[nums[i] % nums.length]
                    + nums.length;
        }
        System.out.println(Arrays.toString(nums));

        System.out.println("The repeating elements are : ");
        // so in here, any value that is greater equal to nums.length * 2 indicate it repeated more than once
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= nums.length * 2) {
                results.add(i);
            }
        }

        return results;
    }

    /**
     * Time Complexity :: O(n)
     * Space Complexity :: O(n)
     * @param nums
     * @return
     */
    public static List<Integer> findDuplicates(int[] nums, String anotherAnswer) {
        List<Integer> results = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        System.out.println(map);

        map.forEach((key, value) -> {
            if (value > 1) {
                results.add(key);
            }
        });

        return results;
    }

    /**
     * Time Complexity :: O(n)
     * Space Complexity :: O(1)
     * @param nums
     * @return
     */
    public static List<Integer> findDuplicates(int[] nums, boolean myOwnAnswer) {
        List<Integer> results = new ArrayList<>();
        int[] stacks = new int [nums.length + 1]; // initial new stack with default value 0

        for (int num : nums) {
            stacks[num]++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (stacks[i] > 1) {
                results.add(i);
            }
        }

        return results;
    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 2, 3, 2, 1, 4, 5, 4};
//        int[] nums = {1, 2, 3, 4, 5};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println(duplicates);

        /*
            EXPECTED OUTPUT:
            ----------------
			[1, 2, 4]

        */

    }

}

