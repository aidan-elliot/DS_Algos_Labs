//********************************************************************
//  ArrayStack.java
//
//  Represents an ArrayStack extensions of a stack. The bottom of
//  the stack is kept at array index 0.
//********************************************************************

import java.util.Stack;

public class ArrayStack<T> extends Stack <T> {
    private final int DEFAULT_CAPACITY = 10;
    private int count;
    private T[] stack;

    /**
     * Creates an empty stack using the default capacity.
     */
    public ArrayStack() {
        count = 0;
        stack = (T[]) (new Object[DEFAULT_CAPACITY]);

    }

    /**
     * Adds the specified element to the top of this stack, expanding
     * the capacity of the stack array if necessary.
     *
     * @return
     */
    public T push(T element) {
        if (count == stack.length)
            expandCapacity();

        stack[count] = element;
        count++;
        return element;
    }

    /**
     * Returns a string representation of this stack.
     */
    public String toString() {
        String result = "<top of stack>\n";

        for (int index = count - 1; index >= 0; index--)
            result += stack[index] + "\n";

        return result + "<bottom of stack>";
    }

    /**
     * Helper method.
     * Creates a new array to store the contents of this stack with
     * twice the capacity of the old one.
     */
    private void expandCapacity() {
        T[] larger = (T[]) (new Object[stack.length * 2]);

        for (int index = 0; index < stack.length; index++)
            larger[index] = stack[index];

        stack = larger;
    }

    /**
     * Removes the element at the top of this stack and returns a
     * reference to it. Throws an EmptyCollectionException if the
     * stack contains no elements.
     */

    public T pop() {
        if (count == 0) {
            System.out.println("Pop operation failed. Stack is empty.");
            return null;
        }
        T temp = stack[count - 1];
        count--;
        return temp;
    }

    /**
     * Returns top without retrieving
     */
    public T peek() {
        if (count == 0) {
            System.out.println("Peek operation failed. Stack is empty.");
            return null;
        }
        return stack[count - 1];
    }

    /**
     * Checks if stack is empty
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Returns the number of elements in the stack
     */
    public int size() {
        return count;
    }
}
