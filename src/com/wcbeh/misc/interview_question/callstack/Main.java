package com.wcbeh.misc.interview_question.callstack;

public class Main {

    public static void methodThree() {
        System.out.println("Three");
    }

    public static void methodTwo() {
        methodThree();
        System.out.println("Two");
    }

    public static void methodOne() {
        methodTwo();
        System.out.println("One");
    }

    public static void main(String[] args) {
        /**
         *
         * When a process is run, it will be put into callstack,
         * and pop out after each sub-process has been completed.
         * Which is why infinite recursion causing stackoverflow.
         *
         * ---CALL STACK---
         * | ....         |
         * |methodThree() |
         * |methodTwo()   |
         * |methodOne()   |
         * |--------------|
         */
        methodOne();
    }

}
