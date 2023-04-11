package com.wcbeh.misc.interview_question.palindromechecker;


import java.util.LinkedList;
import java.util.Queue;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
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
        System.out.println("\nDoubly Linked List:");
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

    public void append (int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    /**
     * Time Complexity :: O(n)
     * Space Complexity :: O(n)
     * @return
     */
    public boolean isPalindrome(boolean myOwnAnswer) {
        if (length % 2 == 0) return false; // palindrome should be odd length

        int mid = length/2;
        Queue<Integer> queue = new LinkedList<>();
        Node temp = head;
        for (int i = 0; i < mid; i++) {
            queue.add(temp.value);
            temp = temp.next;
        }

        System.out.println(queue);

        temp = tail;
        for (int i = 0; i < mid; i++) {
            if (queue.peek() == temp.value) {
                queue.remove();
            }
            temp = temp.prev;
        }

        return queue.isEmpty();
    }

    /**
     * Time Complexity :: O(n)
     * Space Complexity :: O(1)
     * @return
     */
    public boolean isPalindrome() {
        if (head == null) return false;
        Node left = head;
        Node right = tail;
        while(true) {
            if (left == null && right == null) return true;
            if (left.value != right.value) return false;
            left = left.next;
            right = right.prev;
        }
    }

}


