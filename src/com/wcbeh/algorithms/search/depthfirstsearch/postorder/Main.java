package com.wcbeh.algorithms.search.depthfirstsearch.postorder;


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

        System.out.println("\nDFS PostOrder:");
        System.out.println( myBST.DFSPostOrder() );

        /*
            EXPECTED OUTPUT:
            ----------------
            DFS PostOrder:
            [18, 27, 21, 52, 82, 76, 47]

        */

    }

}
