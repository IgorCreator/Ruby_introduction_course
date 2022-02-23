package cracking_the_code_book.stacks_queues;

import java.util.Stack;


public class SortStacksTest {

    public static void main(String[] args) {
        Stack<Integer> integerCustomStack = new Stack<>();
        integerCustomStack.push(50);
        integerCustomStack.push(10);
        integerCustomStack.push(20);
        integerCustomStack.push(2);
        integerCustomStack.push(30);
        integerCustomStack.push(5);

        sort(integerCustomStack);
        print(integerCustomStack);
    }

    static void sort(Stack<Integer> orig) { // Time complexity O(n*n), Space complexity O(n)
        Stack<Integer> r = new Stack<>();
        while (!orig.isEmpty()) {
            Integer tmp = orig.pop();
            while (!r.isEmpty() && r.peek() > tmp) {
                orig.push(r.pop());
            }
            r.push(tmp);
        }
        while (!r.isEmpty()) {
            orig.push(r.pop());
        }
    }

    static void print(Stack<Integer> orig) {
        for (Integer integer : orig) {
            System.out.println(integer);
        }
    }
}