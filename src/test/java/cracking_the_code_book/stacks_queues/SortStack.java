package cracking_the_code_book.stacks_queues;

import java.util.EmptyStackException;
import java.util.Stack;

class SortStack<T> {

    private Stack<T> tempStack;
    private StackNode<T> head;
    int size;

    private static class StackNode<T> {
        private final T data;
        private final StackNode<T> next;

        StackNode(T data) {
            this.data = data;
            this.next = null;
        }

        StackNode(T data, StackNode<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public T pop() {
        if (head == null) throw new EmptyStackException();

        T data = head.data;
        head = head.next;
        size--;
        return data;
    }


    public void push(T newItem) {
        head = new StackNode<>(newItem, head);
        sort();
        size++;
    }

    void sort() {
        Stack<T> r = new Stack<>();
        while (!isEmpty()) {
            /* Insert each element in s in sorted order into r. */
            T tmp = this.pop();
//            while (!r.isEmpty() && r.peek() > tmp) {  //TODO: main condition for integers
            while (!r.isEmpty()) {
                this.push(r.pop());
            }
            r.push(tmp);
        }

        /* Copy the elements from r back into this stack. */
        while (!r.isEmpty()) {
            this.push(r.pop());
        }
    }


    public T peek() {
        if (head == null) throw new EmptyStackException();
        return head.data;
    }

    public int stackSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        StackNode<T> cur = head;
        while (cur != null) {
            System.out.print(cur.data);
            if (cur.next != null)
                System.out.print(" -> ");

            cur = cur.next;
        }
        System.out.println();
    }
}
