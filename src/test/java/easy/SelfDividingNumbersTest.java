package easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SelfDividingNumbersTest {
    @Test
    public void selfDividingNumbersTest() {
        int [] rez1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22};
        List list1 = new ArrayList();
        for (int i = 0; i < rez1.length; i++) {
            list1.add(rez1[i]);
        }
        System.out.println(list1.size());

        int [] rez2 = {11,12,15,22,24,33,36,44,48};
        List list2 = new ArrayList();
        for (int i = 0; i < rez2.length; i++) {
            list2.add(rez2[i]);
        }
        System.out.println(list2.size());


        SelfDividingNumbers dividingNumbers = new SelfDividingNumbers();
        assertEquals(list1, dividingNumbers.selfDividingNumbers(1,22));
        assertEquals(list2, dividingNumbers.selfDividingNumbers(10,50));
    }
}