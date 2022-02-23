package cracking_the_code_book.bit_manipulation;

public class BitTasksGettingandSetting {

    public static void main(String[] args) {
        System.out.println(hasAtLeastOneBit(10, 1));
        System.out.println(setBitInPosition(10, 4));
        System.out.println(clearBitInPosition(26, 4));
        System.out.println(clearBitsMSBthroughI(26, 3));
        System.out.println(clearBitsFromBeginingToPosition(26, 1));
        System.out.println(updateBit(26, 3, false));
    }

    static boolean hasAtLeastOneBit(int num, int i) {
        System.out.println("Binary input is " + Integer.toBinaryString(num));
        int res = num & (1 << i);
        System.out.println("Binary is " + Integer.toBinaryString(res));
        return (res != 0);
    }

    static int setBitInPosition(int num, int position) {
        System.out.println("Binary input is " + Integer.toBinaryString(num));
        int res = num | (1 << position);
        System.out.println("Binary is " + Integer.toBinaryString(res));
        return res;
    }

    static int clearBitInPosition(int num, int position) {
        System.out.println("Binary input is " + Integer.toBinaryString(num));
        int mask = ~(1 << position);
        System.out.println("Mask is " + Integer.toBinaryString(mask));
        int res = num & mask;
        System.out.println("Binary is " + Integer.toBinaryString(res));
        return res;
    }

    static int clearBitsMSBthroughI(int num, int position) {
        System.out.println("Binary input is " + Integer.toBinaryString(num));
        int mask = (1 << position) - 1;
        System.out.println("Mask is " + Integer.toBinaryString(mask));
        int res = num & mask;
        System.out.println("Binary is " + Integer.toBinaryString(res));
        return res;
    }


    static int clearBitsFromBeginingToPosition(int num, int position) {
        System.out.println("Binary input is " + Integer.toBinaryString(num));
        int mask = -1 << (position+1);
        System.out.println("Mask is " + Integer.toBinaryString(mask));
        int res = num & mask;
        System.out.println("Binary is " + Integer.toBinaryString(res));
        return res;
    }

    static int updateBit(int num, int position, boolean isUpdateIn1) {
        System.out.println("Binary input is " + Integer.toBinaryString(num));
        int val = isUpdateIn1 ? 1:0;
        int mask = ~(1 << position);
        System.out.println("Mask is " + Integer.toBinaryString(mask));
        int res = (num & mask) | (val << position);
        System.out.println("Binary is " + Integer.toBinaryString(res));
        return res;
    }


}
