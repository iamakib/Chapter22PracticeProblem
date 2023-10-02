package E22_2;

import java.util.LinkedList;

public class ThreadSafeStack {
    private LinkedList<Integer> stack = new LinkedList<>();

    public synchronized void push(Integer item) {
        stack.push(item);
    }

    public synchronized Integer pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.pop();
    }

    public synchronized boolean isEmpty() {
        return stack.isEmpty();
    }
}

