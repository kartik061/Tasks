package stackExample;

import java.util.LinkedList;

class LinkedListStack<T> {
    private LinkedList<T> list = new LinkedList<>();

    // Push element onto the stack
    public void push(T element) {
        list.addFirst(element);
    }

    // Pop element from the stack
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot pop from an empty stack.");
        }
        return list.removeFirst();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }
}

public class stackExample {
    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Check if the stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());

        // Pop elements from the stack and display
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        // Check if the stack is empty again
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
