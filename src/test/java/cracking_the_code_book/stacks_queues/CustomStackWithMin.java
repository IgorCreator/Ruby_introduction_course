package cracking_the_code_book.stacks_queues;

import java.util.EmptyStackException;

public class CustomStackWithMin {

    public static void main(String[] args) {
        CustomStack integerCustomStack = new CustomStack();
        integerCustomStack.push(2);
        integerCustomStack.push(3);
        integerCustomStack.push(10);
        integerCustomStack.push(30);

        integerCustomStack.print();
        System.out.println("Min value: " + integerCustomStack.min());
    }


    // Last In, First out
    public static class CustomStack {

        private StackNode head;
        int size;

        private static class StackNode {
            private final int data;
            private final StackNode next;
            private final int min;

            StackNode(int data, int min){
                this.data = data;
                this.min = min;
                this.next = null;
            }

            StackNode(int data, StackNode next, int min){
                this.data = data;
                this.min = min;
                this.next = next;
            }
        }

        public int pop(){
            if(head == null) throw new EmptyStackException();

            int data = head.data;
            head = head.next;
            size--;
            return data;
        }

        public void push(int newItem){
            if(head == null)
                head = new StackNode(newItem, newItem);
            else{
                int minValue = Math.min(min(), newItem);
                head = new StackNode(newItem, head, minValue);
            }
            size++;
        }

        public int peek(){
            if(head == null) throw new EmptyStackException();
            return head.data;
        }

        public int stackSize(){
            return size;
        }

        public boolean isEmpty(){
            return head == null;
        }

        public int min(){
            if(head == null) throw new EmptyStackException();
            return head.min;
        }

        public void print(){
            StackNode cur = head;
            while(cur != null){
                System.out.print(cur.data);
                if (cur.next != null)
                    System.out.print(" -> ");

                cur = cur.next;
            }
            System.out.println();
        }
    }
}


