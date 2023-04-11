package com.wcbeh.algorithms.sort.bubblesort;

import java.util.Arrays;

public class BubbleSort {

    /**
     * Time Complexity :: O(n^2)
     * Space Complexity :: O(1), because the swap is instant unlike merge sort need to return an array
     * @param array
     * @param descending
     */
    public static void bubbleSort(int[] array, boolean descending) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (descending) {
                    if (array[j] < array[j + 1]) {
                        // swap
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                } else {
                    if (array[j] > array[j + 1]) {
                        // swap
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
    }

    public static void bubbleSort(int[] array) {
        bubbleSort(array, false);
    }

    public static void main(String[] args) {

        int[] myArray = {4,2,6,5,1,3};

        bubbleSort(myArray);

        System.out.println( Arrays.toString(myArray) );

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6]

         */

    }

}
