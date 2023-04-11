package com.wcbeh.algorithms.search.breadthfirstsearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    public Node root;

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        private Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        if (root == null) return false;
        Node temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * Breadth First Search
     * <br/><br/>
     * The time complexity of Breadth-First Search (BFS) is O(|V| + |E|), where |V| is the number of vertices and |E| is the number of edges in the graph. This is because in the worst case scenario, BFS needs to visit every vertex and every edge in the graph.
     * <br/><br/>
     * The space complexity of BFS is O(|V|), as it needs to store all the vertices in the queue during the traversal. In the worst case scenario, this can be all the vertices in the graph.
     * <br/><br/>
     * Time Complexity :: O(n)
     * Space Complexity :: O(n) if case linked list, if adjacency matrix O(n^2) because it will stored all edges information
     *
     * @return
     */
    public ArrayList<Integer> BFS() {
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();

        if (currentNode != null) {
            queue.add(currentNode);
        }

        while (queue.size() > 0) {
            currentNode = queue.remove();
            results.add(currentNode.value);

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

        return results;
    }

    @Deprecated
    public ArrayList<Integer> BFS(boolean deprecated) {
        ArrayList<Integer> results = new ArrayList<>();

        if (root != null) {
            results.add(root.value);
            traverse(root, results);
        }

        return results;
    }

    @Deprecated
    private void traverse(Node currentNode, ArrayList<Integer> arrayList) {
        if (currentNode != null) {
            if (currentNode.left != null) arrayList.add(currentNode.left.value);
            if (currentNode.right != null) arrayList.add(currentNode.right.value);
            traverse(currentNode.left, arrayList);
            traverse(currentNode.right, arrayList);
        }
    }

}
