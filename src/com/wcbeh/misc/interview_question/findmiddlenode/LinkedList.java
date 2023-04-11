package com.wcbeh.misc.interview_question.findmiddlenode;

import java.util.ArrayList;

public class LinkedList {

    private Node head;
    private Node tail;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (head == null) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("\nLinked List:");
        if (head == null) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    /**
     * Time Complexity :: O(n)
     * Space Complexity :: O(n) - to reduce the space complexity to O(1) store only the length,
     * then traverse again the linked list to find value in the index/2
     * @param myOwnAnswer
     * @return
     */
    public Node findMiddleNode(boolean myOwnAnswer) {
        if (head == null) return null;

        int length = 0;
        Node temp = head;
        ArrayList<Node> arrayList = new ArrayList<>();
        arrayList.add(temp);
        while (temp != null) {
            temp = temp.next;
            arrayList.add(temp);
            length ++;
        }

        return arrayList.get(length/2);
    }

    /**
     * https://www.enjoyalgorithms.com/blog/find-middle-of-linked-list
     * slow is traverse in 1x speed
     * fast is traverse is 2x speed
     * so when fast reach the end, slow must be in the middle
     *
     * Time Complexity :: O(n)
     * Space Complexity :: O(1)
     * @return
     */
    public Node findMiddleNode() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
