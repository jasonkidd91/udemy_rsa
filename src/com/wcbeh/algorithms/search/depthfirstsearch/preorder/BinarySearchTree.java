package com.wcbeh.algorithms.search.depthfirstsearch.preorder;


import java.util.ArrayList;

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
     * Depth First Search - Pre Order
     * Time Complexity :: O(n)
     * Space Complexity :: O(n)
     * @return
     */
    public ArrayList<Integer> DFSPreOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode != null) {
                    results.add(currentNode.value);
                    new Traverse(currentNode.left);
                    new Traverse(currentNode.right);
                }
            }
        }

        new Traverse(root);

        return results;
    }

    @Deprecated
    private void traverse(Node currentNode, ArrayList<Integer> arrayList) {
        if (currentNode != null) {
            arrayList.add(currentNode.value);
            traverse(currentNode.left, arrayList);
            traverse(currentNode.right, arrayList);
        }
    }

}
