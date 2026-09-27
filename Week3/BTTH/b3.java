package Week3.BTTH;
import java.util.*;

class QueueUsingTwoStacks<Item>{
    Stack<Item> stack1;
    Stack<Item> stack2;

    public QueueUsingTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(Item item) {
        stack1.push(item);
    }

    public Item dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return stack2.pop();
    }

    public Item peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return stack2.peek(); 
    }
}
