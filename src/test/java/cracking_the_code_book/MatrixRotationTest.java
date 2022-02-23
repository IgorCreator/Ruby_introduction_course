package cracking_the_code_book;

public class MatrixRotationTest {

    public static void main(String[] args)
    {

        // Test Case 1
        int mat1[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        displayMatrix(mat1);
        rotateMatrix(mat1);
        // Print rotated matrix
        displayMatrix(mat1);

        // Tese Case 2
         int mat2[][] = {
                            {1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}
                        };
        displayMatrix(mat2);
        rotateMatrix(mat2);
        // Print rotated matrix
        displayMatrix(mat2);

        // Tese Case 3
        int mat3[][] = {
                        {1, 2},
                        {4, 5}
                    };
         displayMatrix(mat3);
        rotateMatrix(mat3);
        // Print rotated matrix
        displayMatrix(mat3);
    }

    private static void rotateMatrix(int[][] mat) {
        int size = mat.length;
        if(size != mat[0].length) throw new IllegalArgumentException("incorrect matrix. Should be NxN");

        for (int i = 0; i < size/2; i++) {
            for (int j = i; j < size - i - 1; j++){ // O(n*n)

                int temp = mat[i][j];
                mat[i][j] = mat[size - 1 - j][i];
                mat[size - 1 - j][i] = mat[size - 1 - i][size - 1 - j];
                mat[size - 1 - i][size - 1 - j] = mat[j][size - 1 - i];
                mat[j][size - 1 - i] = temp;
            }
        }


    }

    // Function to print the matrix
    static void displayMatrix(int mat[][])
    {
        int N = mat.length;;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(
                        " " + mat[i][j]);

            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
