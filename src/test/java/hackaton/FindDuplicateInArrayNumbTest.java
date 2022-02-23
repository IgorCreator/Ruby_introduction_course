package hackaton;

import easy.FindDuplicateInArrayNumb;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindDuplicateInArrayNumbTest {

    @Test
    public void nessesaryNumbTest() {
        FindDuplicateInArrayNumb findDuplicate = new FindDuplicateInArrayNumb();
        int[] inputA = {3,6,9,9,12,15,18};
        assertEquals(9, findDuplicate.necessaryNumb(inputA));
        int[] inputB = {2,4,6,8,4,10,12};
        assertEquals(4, findDuplicate.necessaryNumb(inputB));
        int[] inputC = {24,30,36,42,30};
        assertEquals(30, findDuplicate.necessaryNumb(inputC));
        int[] inputD = {};
        assertEquals(0, findDuplicate.necessaryNumb(inputD));
    }
}