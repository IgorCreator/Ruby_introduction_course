package easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class JudgeRouteCircleTest {

    @Test
    public void judgeCircleTest() {
        JudgeRouteCircle aCase = new JudgeRouteCircle();
        assertEquals(true, aCase.judgeCircle("UD"));
        assertEquals(false, aCase.judgeCircle("LL"));
        assertEquals(true, aCase.judgeCircle("ULLDRR"));
    }
}