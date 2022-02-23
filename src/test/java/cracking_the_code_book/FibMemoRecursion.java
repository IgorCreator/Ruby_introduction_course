package cracking_the_code_book;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FibMemoRecursion {

    public static void main(String[] args) {
        FibMemoRecursion fibMemoRecursion = new FibMemoRecursion();
        fibMemoRecursion.fibbonachiCallc(10);

    }

    private void  fibbonachiCallc(int i) {
        assertEquals(fib(i), 55);
        memo.forEach((k, v) -> System.out.println(k + " - " + v));
    }

    Map<Integer, Integer> memo = new HashMap<>();
    private int fib(int num) {
        if(num == 0 || num == 1) return num;
        if(memo.containsKey(num)) return memo.get(num);

        int n = fib(num-1) + fib(num-2);
        memo.put(num, n);
        return n;
    }
}
