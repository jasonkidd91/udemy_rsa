package com.wcbeh.algorithms.extra.floydtortoisehare;

import java.util.Arrays;

public class FloydTortoiseHare {

    /**
     * Floyd's Tortoise & Hare Algorithm
     * - An algorithm to detect a cycle exists in a linked list.
     * <br/><br/>
     * The time complexity of Floyd's Tortoise and Hare algorithm is O(n), where n is the number of nodes in the linked list. This is because both pointers traverse the list at most twice. The space complexity is O(1), as the algorithm only uses two pointers.
     * <br/><br/>
     * The main advantage of this algorithm is its simplicity and efficiency. It can detect cycles in a linked list without requiring any additional data structures. It is also very fast and has a low memory footprint, making it ideal for use in embedded systems or other resource-constrained environments.
     * <br/><br/>
     * One potential disadvantage of the algorithm is that it only works for linked lists, not other types of graphs. Additionally, it can only detect the presence of a cycle, not its length or other properties. Finally, if there are multiple cycles in the linked list, the algorithm may not detect all of them, as it only finds one cycle per run.
     * <br/><br/>
     * Time Complexity :: O(n)
     * Space Complexity :: O(1)
     * @param arr
     */
    public static void findDuplicate(int[] arr) {
        int tortoise = arr[0];
        int hare = arr[0];

        System.out.println("tortoise: " + tortoise + ", hare: " + hare);

        do {
            tortoise = arr[tortoise];
            hare = arr[arr[hare]]; // move twice as fast to tortoise
            System.out.println("tortoise: " + tortoise + ", hare: " + hare);

        } while (tortoise != hare);

        System.out.println("----- Reset to Same Pace -----");

        tortoise = arr[0];

        while (tortoise != hare) {
            tortoise = arr[tortoise];
            hare = arr[hare];
            System.out.println("tortoise: " + tortoise + ", hare: " + hare);
        }

        System.out.print("Cycle meet point is: " + tortoise);
    }

    public static void main (String[] args) {

        // Given array
//        int arr[] = { 2, 6, 4, 1, 3, 1, 5 };
//        int arr[] = {3,1,3,4,2};
//        int arr[] = { 1, 1, 1, 1, 1, 1, 1 };
//        int arr[] = { 0, 1, 2, 3, 4, 5, 6 };
        int arr[] = { 6, 2, 5, 1, 3, 0, 4 };

        System.out.println(Arrays.toString(arr));

        // Function Call
        findDuplicate(arr);
    }

}
