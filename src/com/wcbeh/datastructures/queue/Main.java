package com.wcbeh.datastructures.queue;


public class Main {

    public static void main(String[] args) {

        Queue myQueue = new Queue(4);

        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        myQueue.enqueue(5);
        myQueue.enqueue(6);
        System.out.println(myQueue.dequeue());

        myQueue.getFirst();
        myQueue.getLast();
        myQueue.getLength();

        System.out.println("\nQueue:");
        myQueue.printQueue();

        /*
            EXPECTED OUTPUT:
            ----------------
            First: 4
            Last: 4
            Length: 1

            Queue:
            4

        */

    }

}
