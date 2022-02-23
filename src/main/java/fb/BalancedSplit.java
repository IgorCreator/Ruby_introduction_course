package fb;

import java.util.*;
/*
*
* Given an array of integers (which may include repeated integers), determine if there's a way to split the array into two subsequences A and B such that the sum of the integers in both arrays is the same, and all of the integers in A are strictly smaller than all of the integers in B.
Note: Strictly smaller denotes that every integer in A must be less than, and not equal to, every integer in B.
* */
class BalancedSplit {


    boolean balancedSplitExists(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        // Write your code here
        int totalLeft = 0, totalRight = 0;
        Arrays.sort(arr);
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            totalRight += arr[j--];
            while (i <= j && totalLeft < totalRight) {
                totalLeft += arr[i++];
            }
        }
        return totalLeft == totalRight && arr[i - 1] < arr[j + 1];
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
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
    void printString(String str) {
        System.out.print("[" + str + "]");
    }

    public void run() {
        assertionHelper(new int[]{2, 1, 2, 5}, true);
        assertionHelper(new int[]{3, 6, 3, 4, 4}, false);
        assertionHelper(new int[]{1, 5, 7, 1}, true);
        assertionHelper(new int[]{12, 7, 6, 7, 6}, false);
    }

    public void assertionHelper(int[] arr, boolean expectedRes){
        boolean outputRes = balancedSplitExists(arr);
        check(expectedRes, outputRes);
    }

    public static void main(String[] args) {
        new BalancedSplit().run();
    }
}
