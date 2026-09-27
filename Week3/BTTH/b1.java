package Week3.BTTH;

import java.util.Iterator;
import java.util.NoSuchElementException;

class Stack<Item> implements Iterable<Item> {
    private Node first; // top of stack (most recently added node)
    private int n;      // number of items

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

    public Stack() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public Item pop() {
        if (isEmpty()) throw new RuntimeException("Stack underflow");
        Item item = first.item; // save item to return
        first = first.next;     // delete first node
        n--;
        return item;            // return the saved item
    }

    public Item peek() {
        if (isEmpty()) throw new RuntimeException("Stack underflow");
        return first.item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}


class Queue<Item> implements Iterable<Item> {
    private Node first; // beginning of queue
    private Node last;  // end of queue
    private int n;      // number of elements on queue

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

    public Queue() {
        first = null;
        last  = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue underflow");
        Item item = first.item; // save item to return
        first = first.next;     // delete first node
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;            // return the saved item
    }