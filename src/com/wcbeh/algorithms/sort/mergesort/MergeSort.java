package com.wcbeh.algorithms.sort.mergesort;

import java.util.Arrays;

public class MergeSort {

    public static int[] merge(int[] array1, int[] array2) {
        int[] combined = new int[array1.length + array2.length];
        int index = 0;
        int i = 0;
        int j = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                combined[index] = array1[i];
                i++;
            } else {
                combined[index] = array2[j];
                j++;
            }
            index++;
        }

        // check i remaining
        while (i < array1.length) {
            combined[index] = array1[i];
            i++;
            index++;
        }

        // check j remaining
        while (j < array2.length) {
            combined[index] = array2[j];
            j++;
            index++;
        }

//        while (index < combined.length) {
//            if (j >= array2.length || array1[i] < array2[j]) {
//                combined[index] = array1[i];
//                i++;
//            } else {
//                combined[index] = array2[j];
//                j++;
//            }
//            index++;
//        }

        return combined;
    }

    /**
     * Time Complexity :: O(n log n) -> O(log n) divide and conquer * O(n) merge
     * Space Complexity :: O(n)
     * @param array
     * @return
     */
    public static int[] mergeSort(int[] array) {
        if (array.length == 1) return array;

        int midIndex = array.length / 2;
        int[] left = mergeSort(splitArray(array, 0, midIndex)); // mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int[] right = mergeSort(splitArray(array, midIndex, array.length)); // mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        System.out.println("merge: " + Arrays.toString(left) + " " + Arrays.toString(right));
        return merge(left, right);
    }

    private static int[] splitArray(int[] array, int start, int end) {
        int[] temp = new int[end - start];
        int index = 0;
        for (int i = start; i < end; i++) {
            temp[index] = array[i];
            index++;
        }

        return temp;
    }

    public static void main(String[] args) {

        int[] originalArray = {7,3,6,1,8,4,5,2};

        int [] sortedArray = mergeSort(originalArray);

        System.out.println( "\nOriginal Array: " + Arrays.toString( originalArray ) );

        System.out.println( "\nSorted Array: " + Arrays.toString( sortedArray ) );

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6, 7, 8]

         */

    }

}
