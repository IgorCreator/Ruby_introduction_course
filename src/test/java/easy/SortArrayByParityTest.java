package easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortArrayByParityTest {

    @Test
    public void sortArrayByParityTest() {
        SortArrayByParity sortArrayByParity = new SortArrayByParity();
        int[] inputMatrixA = {3,1,2,4};
        int[] outputA = {2,4,3,1};
        assertArrayEquals(outputA, sortArrayByParity.sortArrayByParity(inputMatrixA));
        assertArrayEquals(outputA, sortArrayByParity.sortArrayByParityWithNewJava(inputMatrixA));
    }
}