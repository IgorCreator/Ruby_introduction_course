package fb;

import java.util.*;

/*
* Suppose we have a list of N numbers, and repeat the following operation until we're left with only a single number: Choose any two numbers and replace them with their sum. Moreover, we associate a penalty with each operation equal to the value of the new number, and call the penalty for the entire list as the sum of the penalties of each operation.
For example, given the list [1, 2, 3, 4, 5], we could choose 2 and 3 for the first operation, which would transform the list into [1, 5, 4, 5] and incur a penalty of 5. The goal in this problem is to find the worst possible penalty for a given input.
*
* * */

class SlowSum {

    int getTotalTime_with_sortiing(int[] arr) { //with_Sorting
        // Write your code here
        Arrays.sort(arr); //O(N*logN)

        int res = 0;

        int sum = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            sum = arr[i] + sum;
            res = sum + res;
        }

        return res;
    }

    int getTotalTime(int[] nums) {
        Status[][] dp = new Status[nums.length][nums.length];
        fillOutStatus(dp);
        for (int l = 1; l < nums.length; l++) {
            for (int i = 0; i + l < nums.length; i++) {
                if (l == 1) {
                    dp[i][i + l].val = nums[i] + nums[i + l];
                    dp[i][i + l].sum = nums[i] + nums[i + l];
                    continue;
                }
                dp[i][i + l].val = Math.max(dp[i + 1][i + l].val + dp[i + 1][i + l].sum + nums[i], dp[i][i + l - 1].val + dp[i][i + l - 1].sum + nums[i + l]);
                dp[i][i + l].sum = Math.max(dp[i + 1][i + l].sum + nums[i], dp[i][i + l - 1].sum + nums[i + l]);
            }
        }
        return dp[0][dp[0].length - 1].val;
    }

    private void fillOutStatus(Status[][] dp) {
        for (Status[] row : dp) {
            for (int i = 0; i < row.length; i++)
                row[i] = new Status();
        }
    }

    class Status {
        int val;
        int sum;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;

    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
        int[] arr_1 = {4, 2, 1, 3};
        int expected_1 = 26;
        int output_1 = getTotalTime(arr_1);
        check(expected_1, output_1);

        int[] arr_2 = {2, 3, 9, 8, 4};
        int expected_2 = 88;
        int output_2 = getTotalTime(arr_2);
        check(expected_2, output_2);

        int[] arr_3 = {2, 100, 100, 1, 99};
        int expected_3 = 1102;
        int output_3 = getTotalTime(arr_3);
        check(expected_3, output_3);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new SlowSum().run();
    }
}