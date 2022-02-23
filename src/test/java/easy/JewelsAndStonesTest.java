package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JewelsAndStonesTest {

    @Test
    public void numJewelsInStonesTest() {
        assertEquals(3, new JewelsAndStones().numJewelsInStones("aA", "aAAbbbb"));
    }
}