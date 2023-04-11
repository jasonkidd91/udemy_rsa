package com.wcbeh.misc.interview_question.hasloop;

import java.util.Vector;

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
                    ", next=" + (next != null ? next.value : null) +
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

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
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
     * Time Complexity :: O(n)
     * Space Complexity :: O(n) - same to use HashSet
     *
     * @param myOwnAnswer
     * @return
     */
    public boolean hasLoop(boolean myOwnAnswer) {
        Node temp = head;
        Vector<Node> traveled = new Vector<>();
        boolean hasloop = false;
        while (temp != null) {
            if (traveled.contains(temp)) {
                hasloop = true;
                break;
            }
            traveled.add(temp);
            temp = temp.next;
        }

        return hasloop;
    }

    /**
     * Use Marker/Flag
     * Time Complexity :: O(n)
     * Space Complexity :: O(1)
     * @param anotherAnswer
     * @return
     */
    public boolean hasLoop(String anotherAnswer) {
        boolean hasloop = false;
        Node head = this.head;
        Node temp = new Node(-1);
        while (head != null) {
            if (head.next == null) {
                // reach the end, no loop
                break;
            }

            if(head.next == temp) {
                // found loop, seem the marker is found
                hasloop = true;
                break;
            }

            // disconnect current node and set the node next become 'temp' as the marker to indicate visited
            Node next = head.next;
            head.next = temp;
            head = next;
        }

        return hasloop;
    }

    /**
     * https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/
     * Using Floyd's Algorithm
     * Time Complexity :: O(n)
     * Space Complexity :: O(1)
     * @return
     */
    public boolean hasLoop() {
        boolean hasloop = false;
        Node tortoise = head;
        Node hare = head;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                hasloop = true;
                break;
            }
        }

        return hasloop;
    }

}


