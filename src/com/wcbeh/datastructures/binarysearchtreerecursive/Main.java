package com.wcbeh.datastructures.binarysearchtreerecursive;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree myBST = new BinarySearchTree();

        System.out.println("----- Insert -----");
        myBST.insert(48);
        myBST.insert(48);

        // 12 - {left: 11, right: 13}
        myBST.insert(12);
        myBST.insert(11);
        myBST.insert(13);

        // 55 - {left: 50, right: 70}
        myBST.insert(55);
        myBST.insert(50);
        myBST.insert(70);

        System.out.println();
        System.out.println("Minimum Value: " + myBST.minValue(myBST.root));
        System.out.println();

        System.out.println("----- Contains -----");
        System.out.println(myBST.contains(11));
        System.out.println(myBST.contains(50));
        System.out.println(myBST.contains(53));

        System.out.println("----- Delete -----");
        myBST.deleteNode(100);


        // ROOT MUST BE PUBLIC FOR THIS LINE TO WORK
        System.out.println("Root: " + myBST.root);


        /*
            EXPECTED OUTPUT:
            ----------------
            Root: null

        */

    }

}
