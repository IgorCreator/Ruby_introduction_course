package fb;

import java.util.*;

/*
Reverse to Make Equal
Given two arrays A and B of length N, determine if there is a way to make A equal to B by reversing
any subarrays from array B any number of times.
* */

class IfTwoArraysEqualbyReversingSubArrays {

    boolean areTheyEqual(int[] array_a, int[] array_b) { // O(A + B) = O(2N) = 0(N); space O(N)
        // Write your code here
        if(array_a.length != array_b.length) return false;

        Map<Integer, Integer> map = new HashMap<>();
        for(Integer i: array_a){     //O(N)
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(Integer j: array_b){    //O(N)
            map.put(j, map.getOrDefault(j, 0) - 1);
        }

        for (int i : map.keySet()) {
            if (map.get(i) != 0) return false;
        }
        return true;
    }

    int test_case_number = 1;
    void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }

    public void run() {
        int[] array_a_1 = {1, 2, 3, 4};
        int[] array_b_1 = {1, 4, 3, 2};
        boolean expected_1 = true;
        boolean output_1 = areTheyEqual(array_a_1, array_b_1);
        check(expected_1, output_1);

        int[] array_a_2 = {1, 2, 3, 4};
        int[] array_b_2 = {1, 4, 3, 3};
        boolean expected_2 = false;
        boolean output_2 = areTheyEqual(array_a_2, array_b_2);
        check(expected_2, output_2);
        // Add your own test cases here

    }

    public static void main(String[] args) {
        new IfTwoArraysEqualbyReversingSubArrays().run();
    }
}