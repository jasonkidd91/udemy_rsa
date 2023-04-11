package com.wcbeh.datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class Graph {

    private final HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public void printGraph() {
        System.out.println(adjList);
    }

    public boolean addVertex(String vertex) {
        if (adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1, String vertex2) {
        ArrayList<String> vertices1 = adjList.get(vertex1);
        ArrayList<String> vertices2 = adjList.get(vertex2);
        if (vertices1 != null && vertices2 != null) {
            if (!vertices1.contains(vertex2)) {
                vertices1.add(vertex2);
            }
            if (!vertices2.contains(vertex1)) {
                vertices2.add(vertex1);
            }
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        ArrayList<String> vertices1 = adjList.get(vertex1);
        ArrayList<String> vertices2 = adjList.get(vertex2);
        if (vertices1 != null && vertices2 != null) {
            vertices1.remove(vertex2);
            vertices2.remove(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex) {
        if (adjList.get(vertex) == null) return false;
        for (String connectedVertex : adjList.get(vertex)) {
            Optional.ofNullable(adjList.get(connectedVertex))
                    .ifPresent(ls -> ls.remove(vertex));
        }
        adjList.remove(vertex);
        return true;
    }

}
