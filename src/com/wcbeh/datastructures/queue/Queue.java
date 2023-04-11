package com.wcbeh.datastructures.queue;

public class Queue {

    private Node first;
    private Node last;
    private int length;

    static class Node {

        public int value;
        public Node next;

        public Node(int value) {
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

    public Queue(int value) {
        Node newNode = new Node(value);
        this.first = newNode;
        this.last = newNode;
        this.length = 1;
    }

    public void printQueue() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getFirst() {
        if (first == null) {
            System.out.println("First: null");
        } else {
            System.out.println("First: " + first.value);
        }
    }

    public void getLast() {
        if (last == null) {
            System.out.println("Last: null");
        } else {
            System.out.println("Last: " + last.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            first = newNode;
        } else {
            last.next = newNode;
        }

        last = newNode;
        length ++;
    }

    public Node dequeue() {
        if (length == 0) return null;

        Node temp = first;
        if (length == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
        }

        temp.next = null;
        length --;

        return temp;
    }

}
