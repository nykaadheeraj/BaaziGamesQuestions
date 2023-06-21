import java.util.LinkedList;
import java.util.Queue;

class Stack {
    private Queue<Integer> queue;

    public Stack() {
        queue = new LinkedList<>();
    }

    public void push(int value) {
        int size = queue.size();
        queue.add(value);

        // Rotate the elements to maintain the stack order
        for (int i = 0; i < size; i++) {
            int dequeued = queue.remove();
            queue.add(dequeued);
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue.remove();
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

class TestingStack {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.peek());

        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());

        System.out.println("Top element: " + stack.peek());

        stack.push(4);

        System.out.println("Pop: " + stack.pop());
        System.out.println("Is empty? " + stack.isEmpty());
    }
}
