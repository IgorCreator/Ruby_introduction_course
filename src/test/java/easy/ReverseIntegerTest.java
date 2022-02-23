package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseIntegerTest {

    @Test
    public void reverseIntegerTest() {
        ReverseInteger reverseClass = new ReverseInteger();
        assertEquals(321, reverseClass.reverseInt(123));
        assertEquals(-123, reverseClass.reverseInt(-321));
        assertEquals(21, reverseClass.reverseInt(120));
        assertEquals(-32, reverseClass.reverseInt(-230));
    }

}
