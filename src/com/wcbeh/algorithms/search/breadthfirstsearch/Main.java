package com.wcbeh.algorithms.search.breadthfirstsearch;


public class Main {

    public static void main(String[] args) {

        BinarySearchTree myBST = new BinarySearchTree();

        /**
         *                47
         *         21            76
         *     18     27     52      82
         */
        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(27);
        myBST.insert(52);
        myBST.insert(82);

        System.out.println("\nBreadth First Search:");
        System.out.println( myBST.BFS() );

        /*
            EXPECTED OUTPUT:
            ----------------
            Breadth First Search:
            [47, 21, 76, 18, 27, 52, 82]

        */

    }

}
