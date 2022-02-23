package easy;

public class TransposeMatrix {
    public int[][] transpose(int[][] A) {
        int[][] rez = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            populateReturnArrayColumn(rez, A[i], i);
        }
        return rez;
    }

    public void populateReturnArrayColumn(int[][] returnArray, int[] row, int index) {
        for (int i = 0; i < row.length; i++) {
            returnArray[i][index] = row[i];
        }
    }
}
