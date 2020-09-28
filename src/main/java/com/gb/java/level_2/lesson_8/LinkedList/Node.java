package com.gb.java.level_2.lesson_8.LinkedList;

public class Node {
    private String val;
    private Node prev;
    private Node next;

    public Node(String val) {
        this(val, null, null);
    }

    public Node(String val, Node prev, Node next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }

    public String getVal() {
        return val;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val='" + val + '\'' +
                ", prev=" + ((prev != null) ? prev.getVal() : null) +
                ", next=" + next +
                '}';
    }
}