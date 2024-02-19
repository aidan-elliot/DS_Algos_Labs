import java.util.NoSuchElementException;

//Task 2
public class LinkedQueue<E> implements Queue<E> {

    private Node<E> head = new Node<E>(); // Dummy node to simplify operations
    private int size; // Number of elements in the queue

    // Add element to the end
    public void add(E element) {
        head.prev = head.prev.next = new Node<E>(element, head.prev, head);
        size++;
    }

    // Get element from the front
    public E element() {
        if (size == 0) throw new NoSuchElementException("Empty queue");
        return head.next.element;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Remove and return front element
    public E remove() {
        if (size == 0) throw new NoSuchElementException("Empty queue");
        Node<E> first = head.next;
        head.next = first.next;
        first.next.prev = head;
        size--;
        return first.element;
    }

    // Get queue size
    public int size() {
        return size;
    }

    // Node class for queue elements
    public static class Node<E> {
        E element; // Stored element
        Node<E> prev, next; // Links to previous and next nodes

        // Constructor for dummy node
        Node() {
            this.prev = this.next = this;
        }

        // Constructor for actual nodes
        Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }
}

