package com.wcbeh.algorithms.sort.quicksort;

import java.util.Arrays;

public class QuickSort {

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private static int pivot(int[] array, int pivotIndex, int endIndex) {
        int pivot = array[pivotIndex];
        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (array[i] < pivot) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
//            System.out.println(Arrays.toString(array) + ": i[" + i + "]");
        }

        // move pivot to between left and right
        swap(array, pivotIndex, swapIndex);

        return swapIndex;
    }

    private static void rQuickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivotIndex = pivot(array, start, end);
            rQuickSort(array, start, pivotIndex - 1); // recursive pivot left
            rQuickSort(array, pivotIndex + 1, end); // recursive pivot right
        }
    }

    /**
     * Time Complexity :: O(n log n)
     * Worst Time Complexity :: O(n^2)  - if all data is sorted
     * Space Complexity :: O(1)
     *
     * @param array
     */
    private static void quickSort(int[] array) {
        rQuickSort(array, 0, array.length - 1);
    }

    public static void main(String[] args) {

        int[] myArray = {4,6,1,7,3,2,5};

        System.out.println( Arrays.toString( myArray ));

        quickSort(myArray);

        System.out.println( Arrays.toString( myArray ) );

        /*
            EXPECTED OUTPUT:
            ----------------
            Returned Index: 3
            [2, 1, 3, 4, 6, 7, 5]

         */

    }

}
