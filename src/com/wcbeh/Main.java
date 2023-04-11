package com.wcbeh;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // https://www.bigocheatsheet.com/
        // Omega(Ω) - Best Case
        // Theta(Θ) - Average Case
        // Omicron(O) - Worst Case

	    String[] timeComplexityOder = {
	            "O(n!)", // horrible code
                "O(2^n)", // horrible code
	            "O(n^2)", // loop within a loop 1000 = 1000000, horrible code
                "O(n log n)", // 1000 = 3000, bad code
                "O(n)", // proportional 1000 = 1000, fair code
                "O(log n)", // divide and conquer 1000 = 3, good code
                "O(1)" // constant, excellent code
	    };

        System.out.println(String.join("\n", timeComplexityOder));
    }

    /**
     * log(a + b)
     */
    private void example1(int a, int b) {
        for (int i = 0; i < a; i++) {
            System.out.println(i);
        }

        for (int i = 0; i < b; i++) {
            System.out.println(i);
        }
    }

    /**
     * log(a * b)
     */
    private void example2(int a, int b) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.println(i);
            }
        }
    }

    private void example3() {
        List<Integer> arrayList = Arrays.asList(11, 3, 23, 7);

        arrayList.add(1); // O(1) as no index change
        arrayList.remove(arrayList.size()-1); // O(1) as no index change

        arrayList.remove(0); // O(n) as there is index change
        arrayList.add(0, 11); // O(n) as there is index change

        arrayList.get(3); // O(1) as directly access the index

        for (int i : arrayList) {
            if (i == 7) {
                System.out.println(i); // O(n)
            }
        }
    }
}
