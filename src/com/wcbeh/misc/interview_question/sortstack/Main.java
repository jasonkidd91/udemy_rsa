package com.wcbeh.misc.interview_question.sortstack;

import java.util.Arrays;

public class Main {

    private static int[] merge(int[] left, int[] right) {
        int[] combined = new int[left.length + right.length];
        int index = 0;
        int i = 0;
        int j = 0;

        while (i < left.length && j < right.length) {
            if (left[i] > right[j]) {
                combined[index] = left[i];
                i ++;
            } else {
                combined[index] = right[j];
                j ++;
            }
            index ++;
        }

        // check i-left remaining
        while (i < left.length) {
            combined[index] = left[i];
            index ++;
            i ++;
        }

        // check j-right remaining
        while (j < right.length) {
            combined[index] = right[j];
            index ++;
            j ++;
        }

        return combined;
    }

    private static int[] mergeSort(int[] array) {
        if (array.length == 1) return array;

        int midIndex = array.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));
        return merge(left, right);
    }

    /**
     * Use Merge Sort =="
     * Time Complexity :: O(n log n)
     * Space Complexity :: O(n)
     * @param stack
     */
    private static void sortStack(Stack<Integer> stack, boolean myOwnAnswer) {
        if (stack.isEmpty()) return;
        int[] array = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            array[i] = stack.pop();
            i++;
        }

        array = mergeSort(array);

        for (int j = 0; j < array.length; j++) {
            stack.push(array[j]);
        }
    }

    /**
     * Time Complexity :: O(n^2)
     * Space Complexity :: O(n)
     * @param stack
     */
    private static void sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!tempStack.isEmpty() && tempStack.peek() > temp) {
                // keep push the biggest number back to stack in order to get the smaller temp value
                stack.push(tempStack.pop());
            }
            tempStack.push(temp);
        }

        System.out.println("\nTemp Stack:");
        tempStack.printStack();

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(1);
        stack.push(4);

        System.out.println("Before sorting:");
        stack.printStack();

        sortStack(stack);

        System.out.println("\nAfter sorting:");
        stack.printStack();

        /*
            EXPECTED OUTPUT:
            ----------------
            Before sorting:
            4
            1
            5
            2
            3

            After sorting:
            1
            2
            3
            4
            5

        */

    }

}

