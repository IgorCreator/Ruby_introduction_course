package easy;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class FlippingAnImageTest {

    @Test
    public void invertImageTest() {
        FlippingAnImage flippingAnImage =  new FlippingAnImage();
        int [][] reversedA = {{0,1,1},{1,0,1},{0,0,0}};
        int [][] resultA = {{1,0,0},{0,1,0},{1,1,1}};
        assertArrayEquals(resultA, flippingAnImage.invertValue(reversedA));
        int [][] reversedB = {{0,0,1,1},{1,0,0,1},{1,1,1,0},{0,1,0,1}};
        int [][] resultB = {{1,1,0,0},{0,1,1,0},{0,0,0,1},{1,0,1,0}};
        assertArrayEquals(resultB, flippingAnImage.invertValue(reversedB));
    }

    @Test
    public void flipAndInvertImageTest() {
        FlippingAnImage flippingAnImage =  new FlippingAnImage();
        int [][] inputA = {{1,1,0},{1,0,1},{0,0,0}};
        int [][] resultA = {{1,0,0},{0,1,0},{1,1,1}};
        assertArrayEquals(resultA, flippingAnImage.flipAndInvertImage(inputA));
        int [][] inputB = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        int [][] resultB = {{1,1,0,0},{0,1,1,0},{0,0,0,1},{1,0,1,0}};
        assertArrayEquals(resultB, flippingAnImage.flipAndInvertImage(inputB));
    }

}
