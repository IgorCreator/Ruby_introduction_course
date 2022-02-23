package easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class TransposeMatrixTest {

    @Test
    public void transposeTest() {
        TransposeMatrix transposeMatrix = new TransposeMatrix();

        int[][] inputMatrxA = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] outputA = {{1,4,7},{2,5,8},{3,6,9}};
        assertArrayEquals(outputA, transposeMatrix.transpose(inputMatrxA));

        int[][] inputMatrxB = {{1,2,3},{4,5,6}};
        int[][] outputB = {{1,4},{2,5},{3,6}};
        assertArrayEquals(outputB, transposeMatrix.transpose(inputMatrxB));
    }
}