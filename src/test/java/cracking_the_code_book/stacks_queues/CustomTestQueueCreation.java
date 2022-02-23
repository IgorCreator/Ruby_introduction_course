package cracking_the_code_book.stacks_queues;

public class CustomTestQueueCreation {

    public static void main(String[] args) {
        CustomQueue<Integer> integerCustomStack = new CustomQueue<>();
        integerCustomStack.add(2);
        integerCustomStack.add(3);
        integerCustomStack.add(10);
        integerCustomStack.add(30);

        integerCustomStack.print();

        try {
            while(true){
                System.out.println(integerCustomStack.remove());
            }
        } catch (Exception e) {
            System.out.println("Stack empty");
        }
    }
}
