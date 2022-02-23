package easy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HammingDistanceTest {

    HammingDistance hammingDistance;

    @Before
    public void init(){
        hammingDistance = new HammingDistance();
    }

    @Test
    public void transformToBinaryTest(){
        int numberForCheck = 4;
        char[] tested = Long.toBinaryString(numberForCheck).toCharArray();
        char[] realBinary = hammingDistance.transformToBinary(numberForCheck);
        for (int index = 0; index < realBinary.length; index++) {
            assertEquals(tested[index], realBinary[index]);
        }
    }

    @Test
    public void changeMassiveByAddingElemTest(){
        char[] needToTest = {'0','0','0','1'};
        char[] x = {'1'};
        char[] changeMassiveByAddingElem = hammingDistance.changeMassiveByAddingElem(x, needToTest.length);
        for (int index = 0; index < changeMassiveByAddingElem.length; index++) {
            assertEquals(needToTest[index], changeMassiveByAddingElem[index]);
        };
    }

    @Test
    public void hammingDistanceTest(){
        assertEquals(1, hammingDistance.hammingDistance(5, 4));
        assertEquals(2, hammingDistance.hammingDistance(1, 4));
        assertEquals(3, hammingDistance.hammingDistance(2, 12));
    }

    @Test
    public void hammingDistanceSecondVarTest(){
        assertEquals(1, hammingDistance.hamDistSecondVar(5, 4));
        assertEquals(2, hammingDistance.hamDistSecondVar(1, 4));
        assertEquals(3, hammingDistance.hamDistSecondVar(2, 12));
    }

    @Test
    public void hamDistThirdVarTest(){
        assertEquals(1, hammingDistance.hamDistThirdVar(5, 4));
        assertEquals(2, hammingDistance.hamDistThirdVar(1, 4));
        assertEquals(3, hammingDistance.hamDistThirdVar(2, 12));
    }

}
