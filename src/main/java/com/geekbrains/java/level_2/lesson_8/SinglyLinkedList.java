package com.geekbrains.java.level_2.lesson_8;

public class SinglyLinkedList implements GeekbrainsList {
    private Node head;

    @Override
    public void add(String o) {
        if (head == null) {
            head = new Node(o);
            return;
        }
        add(head, o);
    }

    private void add(Node current, String o) {
        if (current.getNext() == null) {
            Node next = new Node(o);
            current.setNext(next);
            next.setPrev(current);
            return;
        }
        add(current.getNext(), o);
    }

    @Override
    public void remove(String o) {
        if (head == null) {
            return;
        } else {
            if (head.getVal().equals(o)) {
                Node prev = head.getPrev();
                head = head.getNext();
                head.setPrev(prev);
                return;
            }
        }
        remove(head, head.getNext(), o);
    }

    private void remove(Node prev, Node current, String o) {
        if (current == null) {
            return;
        }
        if (current.getVal().equals(o)) {
            Node next = current.getNext();
            prev.setNext(next);
            next.setPrev(prev);
            return;
        }
        remove(current, current.getNext(), o);
    }

    @Override
    public String toString() {
        return "{" +
                head +
                '}';
    }

    private static class Node {
        private final String val;
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
}
