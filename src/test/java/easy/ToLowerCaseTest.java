package easy;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

public class ToLowerCaseTest {

    @Test
    public void toLowerCaseTest() {
        ToLowerCase aCase = new ToLowerCase();
        assertEquals("hello", aCase.toLowerCase("Hello"));
        assertEquals("lovely", aCase.toLowerCase("LOVELY"));
    }
}
