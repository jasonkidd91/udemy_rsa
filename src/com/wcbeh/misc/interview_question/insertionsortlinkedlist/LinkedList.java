package com.wcbeh.misc.interview_question.insertionsortlinkedlist;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    /**
     * Time Complexity :: O(n^2)
     * Space Complexity :: O(1)
     */
    public void insertionSort(boolean myOwnAnswer) {
        if (head == null) return;
        int i = 1;
        Node temp = head.next;
        while (temp != null) {
            int current = temp.value;

            // reset to iterate from head to current index to perform swap sorting
            temp = head;
            int j = 0;
            while (j != i) {
                if (current < temp.value) {
                    int swap = temp.value;
                    temp.value = current;
                    current = swap;
                }
                temp = temp.next;
                j ++;
            }

            i++;
            temp.value = current;
            temp = temp.next;
        }
    }

    /**
     * https://www.geeksforgeeks.org/insertion-sort-for-singly-linked-list/
     * <br/><br/>
     * 1) Create an empty sorted (or result) list
     * <br/>
     * 2) Traverse the given list, do following for every node.
     * <br/>
     * ......a) Insert current node in sorted way in sorted or result list.
     * <br/>
     * 3) Change head of given linked list to head of sorted (or result) list.
     * <br/><br/>
     * Time Complexity :: O(n^2)
     * Space Complexity :: O(1)
     */
    public void insertionSort() {
        if (head == null) return;
        Node sorted = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            sorted = subInsertionSort(sorted, current);
            current = next;
            System.out.println(sorted);
        }
        head = sorted;
        while(true) {
            if (sorted == null || sorted.next == null) {
                tail = sorted;
                break;
            }
            sorted = sorted.next;
        }
    }

    public Node subInsertionSort(Node sorted, Node newnode) {
        if (sorted == null || newnode.value < sorted.value) {
            // head case
            newnode.next = sorted;
            sorted = newnode;
        } else {
            Node current = sorted;
            while (current.next != null && current.next.value < newnode.value) {
                current = current.next;
            }
            newnode.next = current.next;
            current.next = newnode;
        }
        return sorted;
    }

}
