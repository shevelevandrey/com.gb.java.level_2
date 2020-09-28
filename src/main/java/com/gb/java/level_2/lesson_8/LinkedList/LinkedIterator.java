package com.gb.java.level_2.lesson_8.LinkedList;

public class LinkedIterator implements GeekbrainsIterator{
    private Node current;

    public LinkedIterator(Node current) {
        this.current = current;
    }

    @Override
    public boolean next() {
        if (current.getNext() != null) {
            current = current.getNext();
            return true;
        }
        return false;
    }

    @Override
    public boolean prev() {
        if (current.getPrev() != null) {
            current = current.getPrev();
            return true;
        }
        return false;
    }

    @Override
    public Node getCurrent() {
        return current;
    }

    @Override
    public void toFirst() {
        current = getFirst(current);
    }

    private Node getFirst(Node node) {
        if (node.getPrev() != null) {
            node = getFirst(node.getPrev());
        }
        return node;
    }

    @Override
    public void byEnd() {
        current = getLast(current);
    }

    private Node getLast (Node node) {
        if (node.getNext() != null) {
            node = getLast(node.getNext());
        }
        return node;
    }
}
