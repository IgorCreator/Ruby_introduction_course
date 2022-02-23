package cracking_the_code_book;

import java.util.ArrayList;
import java.util.List;

public class ZeroMatrixTest {

    public static void main(String[] args)
    {

        // Test Case 1
        int mat1[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 0, 12 },
                { 0, 14, 15, 16 }
        };
        displayMatrix(mat1);
        replaceOnZero(mat1);
        // Print rotated matrix
        displayMatrix(mat1);

        // Tese Case 2
        int mat2[][] = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };
        displayMatrix(mat2);
        replaceOnZero(mat2);
        // Print rotated matrix
        displayMatrix(mat2);

        // Tese Case 3
        int mat3[][] = {
                {1, 2},
                {0, 5}
        };
        displayMatrix(mat3);
        replaceOnZero(mat3);
        // Print rotated matrix
        displayMatrix(mat3);
    }

    static class Pair {
        int col;
        int row;

        public Pair(int col, int row) {
            this.col = col;
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public int getRow() {
            return row;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "col=" + col +
                    ", row=" + row +
                    '}';
        }
    }

    private static void replaceOnZero(int[][] mat) {
        List<Pair> toZero = new ArrayList<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++){ // O(m*n)

                if(mat[i][j] == 0) toZero.add(new Pair(i, j));
            }
        }

        System.out.println(toZero.toString());

        for (Pair pair : toZero) {
            int col = pair.getCol();
            for (int n = 0; n < mat.length; n++){ // O(m)
                mat[col][n] = 0;
            }

            int row = pair.getRow();
            for (int n = 0; n < mat[row].length; n++){ // O(n)
                mat[n][row] = 0;
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
