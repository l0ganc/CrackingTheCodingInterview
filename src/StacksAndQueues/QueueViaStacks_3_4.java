package StacksAndQueues;

import java.util.Stack;

public class QueueViaStacks_3_4<T> {
    Stack<T> stackNewest, stackOldest;

    public QueueViaStacks_3_4() {
        stackNewest = new Stack<>();
        stackOldest = new Stack<>();
    }

    public int size() {
        return stackOldest.size() + stackNewest.size();
    }

    public void add(T value) {
        // push onto stackNewest, which always has the newest elements on top
        stackNewest.push(value);
    }

    private void shiftStacks() {
        // move elements from stackNewest to stackOldest
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T peek() {
        shiftStacks();   // ensure stackOldest has the current elements;
        return stackOldest.peek();
    }

    public T remove() {  // ensure stackOldest has the current elements;
        shiftStacks();
        return stackOldest.pop();   // pop the oldest elements
    }
}
