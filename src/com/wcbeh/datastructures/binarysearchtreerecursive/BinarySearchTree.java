package com.wcbeh.datastructures.binarysearchtreerecursive;

public class BinarySearchTree {

    public Node root;

   static class Node {

       public int value;
       public Node left;
       public Node right;

       public Node(int value) {
           this.value = value;
       }

       @Override
       public String toString() {
           return "Node{" +
                   "value=" + value +
                   "\n\t, left=" + formatChild(left) +
                   "\n\t, right=" + formatChild(right) +
                   '}';
       }

       private String formatChild(Node childNode) {
           if (childNode == null) return null;
           return childNode.toString().replaceAll("(\n|\t)", "");
       }

   }

   public BinarySearchTree() { }

    public void insert(int value) {
        root = rInsert(root, value);
    }

    public Node rInsert(Node currentNode, int value) {
       if (currentNode == null) return new Node(value);

       if (value < currentNode.value) {
           currentNode.left = rInsert(currentNode.left, value);
       } else if (value > currentNode.value) {
           currentNode.right = rInsert(currentNode.right, value);
       }

       // equal value case or insertion has been completed
       return currentNode;
    }

    public boolean contains(int value) {
       return rContains(root, value);
    }

    private boolean rContains(Node currentNode, int value) {
       if (currentNode == null) return false;
       if (currentNode.value == value) return true;

       return (value < currentNode.value)
               ? rContains(currentNode.left, value)
               : rContains(currentNode.right, value);
    }

    public int minValue(Node currentNode) {
       while (currentNode.left != null) {
           currentNode = currentNode.left;
       }
       return currentNode.value;
    }

    public void deleteNode(int value) {
//        if (contains(value)) {
//            root = rDeleteNode(root, value);
//        }
        rDeleteNode(root, value);
    }

    public Node rDeleteNode(Node currentNode, int value) {
       if (currentNode == null) return null;

       if (value < currentNode.value) {
           currentNode.left = rDeleteNode(currentNode.left, value);
       } else if (value > currentNode.value) {
           currentNode.right = rDeleteNode(currentNode.right, value);
       } else { // equal case, currentNode.value == value

           if (currentNode.left == null && currentNode.right == null) {
               // if do not have child, directly delete
               return null;
           } else if (currentNode.left != null && currentNode.right != null) {
               // if have both left & right child
               int subTreeMin = minValue(currentNode.right); // find most minimal value from right tree which is a leaf
               currentNode.right = rDeleteNode(currentNode.right, subTreeMin); // delete the leaf with minimal value
               currentNode.value = subTreeMin; // replace current node value with the minimal value to achieve deletion
           }  else {
               // if only have one child (left or right), take right if available else left
               return currentNode.right != null
                       ? currentNode.right
                       : currentNode.left;
           }
       }

       return currentNode;
    }
}
