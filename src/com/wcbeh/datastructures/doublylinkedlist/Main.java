package com.wcbeh.datastructures.doublylinkedlist;


public class Main {

    public static void main(String[] args) {

        DoublyLinkedList myDLL = new DoublyLinkedList(7);

        myDLL.append(5);
        myDLL.append(6);
        myDLL.append(7);
        System.out.println(myDLL.remove(1));
//        System.out.println(myDLL.insert(3, 2));
//        System.out.println(myDLL.set(0, 2));;
//        myDLL.append(1);
//        myDLL.append(2);
//        myDLL.append(3);
//        myDLL.append(4);
//        System.out.println(myDLL.get(2));
//        myDLL.append(1);
//        System.out.println(myDLL.removeFirst());
//        myDLL.prepend(1);
//        myDLL.prepend(2);
//        myDLL.append(8);
//        myDLL.append(9);
//        System.out.println(myDLL.removeLast());
//        System.out.println(myDLL.removeLast());

        myDLL.getHead();
        myDLL.getTail();
        myDLL.getLength();

        System.out.println("\nDoubly Linked List:");
        myDLL.printList();

        /*
            EXPECTED OUTPUT:
            ----------------
            Head: 7
            Tail: 7
            Length: 1

            Doubly Linked List:
            7

        */

    }

}
