package com.wcbeh.misc.interview_question.factorial;

public class Main {

    public static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n -1);
    }

    public static void main(String[] args) {
        System.out.println( factorial(4) );
    }

}
