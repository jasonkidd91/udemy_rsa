package com.wcbeh.algorithms.sort.selectionsort;


import java.util.Arrays;

public class SelectionSort {

    /**
     * Time Complexity :: O(n^2)
     * Space Complexity :: O(1)
     * @param array
     */
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // found lowest index
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {

        int[] myArray = {4,2,6,5,1,3};

        selectionSort(myArray);

        System.out.println( Arrays.toString(myArray) );

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6]

         */

    }

}
