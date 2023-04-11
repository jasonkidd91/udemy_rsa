package com.wcbeh.datastructures.stack;


public class Main {

    public static void main(String[] args) {

        Stack myStack = new Stack(4);

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.push(5);
        myStack.push(7);
        System.out.println(myStack.pop());

        myStack.getTop();
        myStack.getHeight();

        System.out.println("\nStack:");
        myStack.printStack();

        /*
            EXPECTED OUTPUT:
            ----------------
            Top: 4
            Height: 1

            Stack:
            4

        */

    }

}
