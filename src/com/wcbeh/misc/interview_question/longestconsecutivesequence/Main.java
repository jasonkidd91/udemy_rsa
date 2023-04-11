package com.wcbeh.misc.interview_question.longestconsecutivesequence;

import java.util.HashSet;
import java.util.Set;

public class Main {

    /**
     * Time Complexity :: O(n*m)
     * Space Complexity :: O(1)
     * @param nums
     * @param myOwnAnswer
     * @return
     */
    public static int longestConsecutiveSequence(int[] nums, boolean myOwnAnswer) {
        int max_count = 0;
        int count = 0;
        int i = 0;
        int j = 0;
        int temp = nums[0];
        while (true) {
            if (temp + 1 == nums[j]) {
                count++;
                max_count = Math.max(max_count, count);
                temp = nums[j];
                j = 0;
            }

            if (j + 1 >= nums.length) {
                // reset
                i++;
                if (i >= nums.length) break;
                temp = nums[i];
                j = 0;
                count = 0;
            } else {
                j++;
            }
        }

        return max_count + 1;
    }

    /**
     * Time Complexity :: O(n^2)
     * Space Complexity :: O(n)
     * @param nums
     * @return
     */
    public static int longestConsecutiveSequence(int[] nums, String anotherAnswer) {
        int max_count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        for (int i : set) {
            int count = 0;
            int next = i;
            while(set.contains(next+1)) {
                next++;
                count++;
                max_count = Math.max(max_count, count);
            }
        }

        return max_count + 1;
    }

    /**
     * https://www.geeksforgeeks.org/longest-consecutive-subsequence/
     * Time Complexity :: O(n)
     * Space Complexity :: O(n)
     * @param nums
     * @return
     */
    public static int longestConsecutiveSequence(int[] nums) {
        int max_count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        for (int num : nums) {
            // check if current num-1 exists in set
            // if yes mean it is not start value, so ignore
            if (!set.contains(num - 1)) {
                System.out.println(num);
                int j = num;
                // continuous loop to get next value
                while (set.contains(j)) {
                    System.out.print("=");
                    // TODO solution suggest to do remove, but as tested it will increase our loop count
                    // TODO perhaps the improvement side is happen in hashset contains
//                    set.remove(j); // this will improve runtime by avoiding the repetitive counts of elements
                    j++;
                }

                max_count = Math.max(max_count, j - num);
                System.out.println();
            }
        }

        return max_count;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int longest = longestConsecutiveSequence(nums);
        System.out.println(longest);

        /*
            EXPECTED OUTPUT:
            ----------------
            4

        */

    }

}

