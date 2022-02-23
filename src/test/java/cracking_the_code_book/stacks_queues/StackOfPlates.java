package cracking_the_code_book.stacks_queues;

import java.util.*;

public class StackOfPlates {

    public static void main(String[] args) {
        StackPlates integerCustomStack = new StackPlates(5);
        integerCustomStack.push(2);
        integerCustomStack.push(3);
        integerCustomStack.push(10);
        integerCustomStack.push(30);
        integerCustomStack.push(50);
        integerCustomStack.push(8);
        integerCustomStack.push(11);

        integerCustomStack.print();
        System.out.println("Peek value: " + integerCustomStack.peek());
        System.out.println("Deleted el: " + integerCustomStack.pop());
        System.out.println("Deleted el: " + integerCustomStack.pop());
        System.out.println("Peek value: " + integerCustomStack.peek());
        System.out.println("Deleted el: " + integerCustomStack.pop());
        integerCustomStack.print();
    }


    // Last In, First out
    public static class StackPlates {

        private final int MAX_STACK_OF_PLATES;
        private final List<Stack<StackNode>> setOfStacks;
        private int size = 0;
        private StackNode head;

        public StackPlates(int size) {
            MAX_STACK_OF_PLATES = size;
            setOfStacks = new ArrayList<>();
            setOfStacks.add(new Stack<>());
        }

        private static class StackNode {
            private final int data;
            private final StackNode next;

            StackNode(int data) {
                this.data = data;
                this.next = null;
            }

            public StackNode(int data, StackNode next) {
                this.data = data;
                this.next = next;
            }
        }

        public void push(int newItem) {
            Stack<StackNode> lastStack = getLastStack();

            if(lastStack.size() == 0){ // first element to add
                StackNode newEl = new StackNode(newItem);
                head = newEl;
                lastStack.push(newEl);
            } else if (lastStack.size() == MAX_STACK_OF_PLATES){ // we at capacity -> create new stack
                Stack<StackNode> newStackOfPlates = new Stack<>();
                StackNode newEl = new StackNode(newItem);
                head = newEl;
                newStackOfPlates.push(newEl);
                setOfStacks.add(newStackOfPlates);
            } else {
                StackNode newEl = new StackNode(newItem, head);
                head = newEl;
                lastStack.push(newEl);
            }

            size++;
        }

        public int pop() {
            if(setOfStacks.size() == 0)
                throw new EmptyStackException();

            int data = 0;

            Stack<StackNode> lastStack = getLastStack();
            StackNode toRemove = lastStack.pop();
            data = toRemove.data;

            if(toRemove.next == null){
                setOfStacks.remove(setOfStacks.size() - 1);
                head = setOfStacks.get(setOfStacks.size() - 1).peek();
            } else
                head = toRemove.next;

            size--;
            return data;
        }

        private Stack<StackNode> getLastStack() {
            return setOfStacks.get(setOfStacks.size() - 1);
        }

        public int peek() {
            if (head == null) throw new EmptyStackException();
            return head.data;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void print() {
            for (Stack<StackNode> setOfStack : setOfStacks) {
                StackNode cur = setOfStack.peek();
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
}
