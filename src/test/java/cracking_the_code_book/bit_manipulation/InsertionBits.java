package cracking_the_code_book.bit_manipulation;

import cracking_the_code_book.utils.AssortedMethods;

public class InsertionBits {

    public static int updateBits(int n, int m, int i, int j) {
        // Validation
        if (i > j || i < 0 || j >= 32) {
            return 0;
        }

		/* Create a mask to clear bits i through j in n
		/* EXAMPLE: i = 2, j = 4. Result should be 11100011.
		 * (Using 8 bits for this example.  This is obviously not actually 8 bits.)
		 */
        int allOnes = ~0; // allOnes = 11111111
        System.out.println(AssortedMethods.toFullBinaryString(allOnes));

        int left = j < 31 ? (allOnes << (j + 1)) : 0; // 1s until position j, then 0s. left = 11100000
        System.out.println(AssortedMethods.toFullBinaryString(left));
        int right = ((1 << i) - 1); // 1s after position i.  right = 00000011
        System.out.println(AssortedMethods.toFullBinaryString(right));
        int mask = left | right; // All 1s, except for 0s between i and j. mask = 11100011
        System.out.println(AssortedMethods.toFullBinaryString(mask));

        /* Clear i through j, then put m in there */
        int n_cleared = n & mask; // Clear bits j through i.
        System.out.println(AssortedMethods.toFullBinaryString(n_cleared));
        int m_shifted = m << i; // Move m into correct position.
        System.out.println(AssortedMethods.toFullBinaryString(m_shifted));

        /* OR them, and we're done! */
        return n_cleared | m_shifted;
    }

    public static void main(String[] args) {
        int a = ~23423;
        System.out.println("a: " + AssortedMethods.toFullBinaryString(a));
        int b = 5;
        System.out.println("b: " + AssortedMethods.toFullBinaryString(b));
        int c = updateBits(a, b, 29, 31);
        System.out.println("res: " + AssortedMethods.toFullBinaryString(c));

        a = 2048;
        System.out.println("a: " + AssortedMethods.toFullBinaryString(a));
        b = 38;
        System.out.println("b: " + AssortedMethods.toFullBinaryString(b));
        c = updateBits(a, b, 2, 6);
        System.out.println("res: " + AssortedMethods.toFullBinaryString(c));
    }

}
