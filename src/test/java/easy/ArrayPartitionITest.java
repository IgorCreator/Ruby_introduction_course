package easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayPartitionITest {

    @Test
    public void arrayPairSumTest() {
        ArrayPartitionI partitionI = new ArrayPartitionI();
        int[] inputMatrixA = {1,4,3,2};
        int outputA = 4;
        assertEquals(outputA, partitionI.arrayPairSum(inputMatrixA));
    }
}