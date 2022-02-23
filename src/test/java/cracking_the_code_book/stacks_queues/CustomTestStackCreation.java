package cracking_the_code_book.stacks_queues;

import static org.junit.Assert.assertEquals;

public class CustomTestStackCreation {

    public static void main(String[] args) {
        CustomStack<Integer> integerCustomStack = new CustomStack<>();
        integerCustomStack.push(2);
        integerCustomStack.push(3);
        integerCustomStack.push(10);
        integerCustomStack.push(30);

        integerCustomStack.print();

        try {
            while(true){
                System.out.println(integerCustomStack.pop());
            }
        } catch (Exception e) {
            System.out.println("Stack empty");
        }
    }
}
