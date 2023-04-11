package com.wcbeh.misc.interview_question.itemincommon;

import java.util.HashMap;

public class Main {

    public static boolean itemInCommonInefficient(int[] array1, int[] array2) {
        for (int i : array1) {
            for (int j : array2) {
                if (i == j) return true;
            }
        }
        return false;
    }

    public static boolean itemInCommonEfficient(int[] array1, int[] array2) {
        HashMap<Integer, Boolean> myHashMap = new HashMap<Integer, Boolean>();

        for (int i : array1) {
            myHashMap.put(i, true);
        }

        for (int j : array2) {
            if (myHashMap.get(j) != null) return true;
        }

        return false;
    }

    public static void main(String[] args) {

        int[] array1 = {1, 3, 5};
        int[] array2 = {2, 4, 5};

        System.out.println("---- Inefficient O(n^2) ----");
        System.out.println(itemInCommonInefficient(array1, array2));

        System.out.println("---- Efficient O(n) ----");
        System.out.println(itemInCommonEfficient(array1, array2));

    }

}
