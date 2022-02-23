package easy;

public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length < 1 || A[0].length < 1) return A;
        int m = A.length, n = A[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][n - 1 - j] ^ 1;
                A[i][n - 1 - j] = temp ^ 1;
            }
            if (n % 2 != 0) {
                A[i][n / 2] ^= 1;
            }
        }
        return A;
    }

    public int[][] invertValue(int[][] reversedArray) {
        for (int i = 0; i<reversedArray.length; i++) {
            int lengthOfElement = reversedArray[i].length;
            for (int j = 0; j<lengthOfElement; j++) {
                if (reversedArray[i][j] == 0) {
                    reversedArray[i][j] = 1;
                } else if (reversedArray[i][j] == 1) {
                    reversedArray[i][j] = 0;
                } else
                    throw new IllegalArgumentException("Only 0 or 1 can be in Arrays");
            }
        }
        return reversedArray;
    }
}
