package com.wcbeh.datastructures.stack;

public class Stack {

    private Node top;
    private int height;

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

    public Stack(int value) {
        Node newNode = new Node(value);
        this.top = newNode;
        this.height = 1;
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getTop() {
        if (top == null) {
            System.out.println("Top: null");
        } else {
            System.out.println("Top: " + top.value);
        }
    }

    public void getHeight() {
        System.out.println("Height: " + height);
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        height ++;
    }

    public Node pop() {
        if (height == 0) return null;

        Node temp = top;
        top = top.next;
        temp.next = null;
        height --;

        return temp;
    }

}
