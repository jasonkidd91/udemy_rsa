package com.wcbeh.misc.interview_question.mergesortedlist;

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
     * Space Complexity :: O(1)
     * @param list
     */
    public void merge(LinkedList list, boolean myOwnAnswer) {
        if (list != null && list.length > 0) {
            Node ls1 = head;
            Node ls2 = list.head;
            while (ls1 != null) {
                Node ls1Next = ls1.next;
                Node ls2Next = ls2.next;
                ls1.next = ls2;
                ls2.next = ls1Next;

                if (ls1Next == null) {
                    tail = ls2;
                }

                ls1 = ls1Next;
                ls2 = ls2Next;
                length ++;
            }

            // remaining
            if (ls2 != null) {
                tail.next = ls2;
                tail = list.tail;
                length ++;
            }
        }
    }

    /**
     * Time Complexity :: O(n + m)
     * Space Complexity :: O(n)
     * @param list
     */
    public void merge(LinkedList list) {
        Node newNode = merge(head, list.head);

        head = newNode;
        Node temp = newNode;
        int length = 0;
        while (temp != null) {
            if (temp.next == null) {
                tail = temp;
            }

            temp = temp.next;
            length ++;
        }
        this.length = length;
    }

    private Node merge(Node nodeA, Node nodeB) {
        if (nodeA == null) return nodeB;
        if (nodeB == null) return nodeA;
        if (nodeA.value < nodeB.value) {
            nodeA.next = merge(nodeA.next, nodeB);
            return nodeA;
        } else {
            nodeB.next = merge(nodeA, nodeB.next);
            return nodeB;
        }
    }


}


