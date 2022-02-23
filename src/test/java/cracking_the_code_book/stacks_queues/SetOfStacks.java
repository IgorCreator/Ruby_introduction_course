package cracking_the_code_book.stacks_queues;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class SetOfStacks {
    private final int maxStackSize;
    private final ArrayList<Stack> stacks;

    SetOfStacks(int sizeOfStack) {
        stacks = new ArrayList<>();
        maxStackSize = sizeOfStack;
    }

    public void push(int v) {
        Stack lastStack = getLastStack();
        if (lastStack != null && !lastStack.isFull()) {
            lastStack.push(v);
        } else {
            Stack newStack = new Stack(maxStackSize);
            newStack.push(v);
            stacks.add(newStack);
        }
    }

    public int pop() {
        Stack lastStack = getLastStack();
        if (lastStack == null) throw new EmptyStackException();

        int data = lastStack.pop();
        if (lastStack.isEmpty()) stacks.remove(stacks.size() - 1);
        return data;
    }

    public boolean isEmpty() {
        Stack last = getLastStack();
        return last == null || last.isEmpty();
    }

    public int popAt(int index) {
        return leftShift(index, true);
    }

    public int leftShift(int index, boolean removeTop) {
        Stack stack = stacks.get(index);
        int removed_item;
        if (removeTop) removed_item = stack.pop();
        else removed_item = stack.removeBottom();
        if (stack.isEmpty()) {
            stacks.remove(index);
        } else if (stacks.size() > index + 1) {
            int v = leftShift(index + 1, false);
            stack.push(v);
        }
        return removed_item;
    }

    private Stack getLastStack() {
        if (stacks.size() == 0) throw new EmptyStackException();
        return stacks.get(stacks.size() - 1);
    }

    public static class Stack {
        private final int capacity;
        public Node top, bottom;
        public int size = 0;

        public Stack(int capacity) { this.capacity = capacity; }
        public boolean isFull() { return capacity == size; }

        public void push(int v) {
            if (size >= capacity) return;
            size++;
            Node newNode = new Node(v);
            if (size == 1) bottom = newNode;
            join(newNode, top) ;
            top = newNode;
        }

        public void join(Node above, Node below) {
            if (below != null) below.above = above;
            if (above != null) above.below = below;
        }

        public int pop() {
            Node t = top;
            top = top.below;
            size--;
            return t.value;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int removeBottom() {
            Node b = bottom;
            bottom = bottom.above;
            if (bottom != null) bottom.below = null;
            size--;
            return b.value;
        }

        static class Node {
            Node above;
            Node below;
            int value;

            Node(int value){
                this.value = value;
            }
        }
    }


}
