package cracking_the_code_book.bit_manipulation;

public class ArithmeticAndLogicShift {

    public static void main(String[] args) {
        System.out.println(repeatedArithmeticShift(-10, 2));
        System.out.println(repeatedArithmeticShift(10, 2));
        System.out.println(repeatedLogicalShift(10, 3));
    }

    static int repeatedArithmeticShift(int x, int count){
        System.out.println("Binary input is " + Integer.toBinaryString(x));
        for(int i = 0; i < count; i++){
            x >>= 1; // Arithmetic shift by 1
            System.out.println("Binary is " + Integer.toBinaryString(x));
        }
        return x;
    }

    static int repeatedLogicalShift(int x, int count){
        System.out.println("Binary input is " + Integer.toBinaryString(x));
        for(int i = 0; i < count; i++){
            x >>>= 1; //Logical shift by 1
            System.out.println("Binary is " + Integer.toBinaryString(x));
        }
        return x;
    }
}
