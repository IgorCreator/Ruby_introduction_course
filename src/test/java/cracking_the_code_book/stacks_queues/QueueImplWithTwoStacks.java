package cracking_the_code_book.stacks_queues;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueImplWithTwoStacks<T> {

    private Stack<T> stackNewest;
    private Stack<T> stackOldest;

    public QueueImplWithTwoStacks() {
        stackNewest = new Stack<>();
        stackOldest = new Stack<>();
    }

    public int size(){
        return stackNewest.size() + stackOldest.size();
    }

    public void add(T item) {
        stackNewest.push(item);
    }

    public T remove() {
        shiftStack();
        return stackOldest.pop();
    }

    public T peek() {
        shiftStack();
        return stackOldest.peek();
    }

//    In this approach, stackNewest has the newest elements on top and stackOldest has the oldest
//    elements on top. When we dequeue an element, we want to remove the oldest element first, and so we
//    dequeue from stackOldest. If stackOldest is empty, then we want to transfer all elements from
//    stackNewest into this stack in reverse order. To insert an element, we push onto stackNewest, since it
//    has the newest elements on top.
    private void shiftStack() {
        if(stackOldest.isEmpty()){
            while(!stackNewest.isEmpty()){
                stackOldest.push(stackNewest.pop());
            }
        }

    }

    public static void main(String[] args) {
        QueueImplWithTwoStacks<Integer> queueImplWithTwoStacks = new QueueImplWithTwoStacks<>();
        queueImplWithTwoStacks.add(2);
        queueImplWithTwoStacks.add(5);
        queueImplWithTwoStacks.add(1);
        queueImplWithTwoStacks.add(10);
        queueImplWithTwoStacks.remove();
        queueImplWithTwoStacks.add(20);
        queueImplWithTwoStacks.remove();

    }

}
