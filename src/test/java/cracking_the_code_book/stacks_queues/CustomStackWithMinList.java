package cracking_the_code_book.stacks_queues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class CustomStackWithMinList {

    public static void main(String[] args) {
        CustomStack integerCustomStack = new CustomStack();
        integerCustomStack.push(2);
        integerCustomStack.push(3);
        integerCustomStack.push(10);
        integerCustomStack.push(30);

        integerCustomStack.print();
        System.out.println("Min value: " + integerCustomStack.min());
        System.out.println("Deleted el: " + integerCustomStack.pop());
        System.out.println("Min value: " + integerCustomStack.min());
    }


    // Last In, First out
    public static class CustomStack {

        private StackNode head;
        private List<Integer> minDb;

        private static class StackNode {
            private final int data;
            private StackNode next;

            StackNode(int data) {
                this.data = data;
            }

            public StackNode(int data, StackNode next) {
                this.data = data;
                this.next = next;
            }
        }

        public CustomStack() {
            this.minDb = new ArrayList<>();
        }

        public int pop() {
            if (head == null) throw new EmptyStackException();

            int data = head.data;
            head = head.next;
            if (data == min()) minDb.remove(minDb.size() - 1);

            return data;
        }

        public void push(int newItem) {
            if (head == null) {
                head = new StackNode(newItem);
                minDb.add(newItem);
            } else {
                if (min() > newItem) minDb.add(newItem);
                head = new StackNode(newItem, head);
            }
        }

        public int peek() {
            if (head == null) throw new EmptyStackException();
            return head.data;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int min() {
            if (head == null) throw new EmptyStackException();
            return minDb.get(minDb.size() - 1);
        }

        public void print() {
            StackNode cur = head;
            while (cur != null) {
                System.out.print(cur.data);
                if (cur.next != null)
                    System.out.print(" -> ");

                cur = cur.next;
            }
            System.out.println();
        }
    }
}


