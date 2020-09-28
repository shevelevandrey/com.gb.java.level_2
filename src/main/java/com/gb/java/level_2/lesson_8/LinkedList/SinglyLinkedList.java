package com.gb.java.level_2.lesson_8.LinkedList;

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
            if (next != null) {
                next.setPrev(prev);
            }
            return;
        }
        remove(current, current.getNext(), o);
    }

    @Override
    public GeekbrainsIterator getIterator() {
        return new LinkedIterator(head);
    }

    @Override
    public String toString() {
        return "{" +
                head +
                '}';
    }
}
