package com.wcbeh.datastructures.graph;

public class Main {

    public static void main(String[] args) {

        Graph myGraph = new Graph();

        System.out.println("---- Add Vertex ----");
        System.out.println(myGraph.addVertex("A"));
        System.out.println(myGraph.addVertex("A"));
        System.out.println(myGraph.addVertex("B"));
        System.out.println(myGraph.addVertex("C"));
        System.out.println(myGraph.addVertex("D"));

        System.out.println("---- Add Edge ----");
        System.out.println(myGraph.addEdge("A", "B"));
        System.out.println(myGraph.addEdge("B", "A"));
        System.out.println(myGraph.addEdge("A", "C"));
        System.out.println(myGraph.addEdge("B", "C"));
        System.out.println(myGraph.addEdge("A", "D"));
        System.out.println(myGraph.addEdge("B", "D"));
        System.out.println(myGraph.addEdge("C", "D"));

        System.out.println("---- Remove Edge ----");
        System.out.println(myGraph.removeEdge("A", "C"));
        System.out.println(myGraph.removeEdge("B", "A"));
        System.out.println(myGraph.removeEdge("A", "B"));

        System.out.println("---- Remove Vertex ----");
        System.out.println(myGraph.removeVertex("D"));
        System.out.println(myGraph.removeVertex("E"));

        System.out.println("\nGraph:");
        myGraph.printGraph();

        /*
            EXPECTED OUTPUT:
            ----------------
            Graph:
            {A=[], B=[]}

        */

    }

}
