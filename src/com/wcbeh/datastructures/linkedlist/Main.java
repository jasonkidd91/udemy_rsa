package com.wcbeh.datastructures.linkedlist;

public class Main {

    public static void main(String[] args) {

        LinkedList myLinkedList = new LinkedList(4);

//        myLinkedList.append(5);
//        myLinkedList.append(6);
//        myLinkedList.append(7);
        myLinkedList.reverse();
//        System.out.println(myLinkedList.remove(3));
//        System.out.println(myLinkedList.insert(1, 7));
//        System.out.println(myLinkedList.set(2, 7));
//        System.out.println(myLinkedList.get(0));
//        System.out.println(myLinkedList.removeFirst());
//        System.out.println(myLinkedList.removeLast());
//        myLinkedList.append(5);
//        myLinkedList.prepend(6);


        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();

        System.out.println("\nLinked List:");
        myLinkedList.printList();

        /*
            EXPECTED OUTPUT:
            ----------------
            Head: 4
            Tail: 4
            Length: 1

            Linked List:
            4

        */

    }

}