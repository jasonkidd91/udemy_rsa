package com.wcbeh.datastructures.hashtable;

public class Main {

    public static void main(String[] args) {

        HashTable myHashTable = new HashTable();

        myHashTable.set("screws", 140);

        myHashTable.set("bolts", 200);

        myHashTable.set("nails", 1000);
        myHashTable.set("nuts", 1200);
        myHashTable.set("lumber", 400);
        myHashTable.set("tile", 500);

        System.out.println(myHashTable.keys());

        System.out.println("bolts: " + myHashTable.get("bolts"));
        System.out.println("bb: " + myHashTable.get("bb"));
        System.out.println("tile: " + myHashTable.get("tile"));

        myHashTable.printTable();


        /*
            EXPECTED OUTPUT:
            ----------------
            0:
            1:
            2:
            3:
            4:
            5:
            6:

    	*/

    }

}
