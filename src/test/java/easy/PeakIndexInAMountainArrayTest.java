package easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class PeakIndexInAMountainArrayTest {

    @Test
    public void peakIndexInMountainArrayTest() {
        int[] input = {0, 2, 3, 2, 1, 0};
        PeakIndexInAMountainArray aMountainArray = new PeakIndexInAMountainArray();
        assertEquals(2, aMountainArray.peakIndexInMountainArray(input));
    }
}