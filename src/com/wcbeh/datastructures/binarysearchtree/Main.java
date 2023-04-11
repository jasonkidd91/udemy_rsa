package com.wcbeh.datastructures.binarysearchtree;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree myBST = new BinarySearchTree();

        System.out.println("----- Insert -----");
        System.out.println(myBST.insert(48));
        System.out.println(myBST.insert(48));
        System.out.println(myBST.insert(12));
        System.out.println(myBST.insert(50));

        System.out.println("----- Contains -----");
        System.out.println(myBST.contains(11));
        System.out.println(myBST.contains(50));


        // ROOT MUST BE PUBLIC FOR THIS LINE TO WORK
        System.out.println("Root: " + myBST.root);


        /*
            EXPECTED OUTPUT:
            ----------------
            Root: null

        */

    }

}
