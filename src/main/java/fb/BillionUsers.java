package fb;

/*
* We have N different apps with different user growth rates. At a given time t, measured in days,
* the number of users using an app is g^t (for simplicity we'll allow fractional users),
* where g is the growth rate for that app. These apps will all be launched at the same time and no user
*  ever uses more than one of the apps. We want to know how many total users there are when you add together the number of users from each app.
After how many full days will we have 1 billion total users across the N apps?
* */

public class BillionUsers {

    private final int billion = 1_000_000_000;

    public boolean growthRateHelper(int mid, float[] growthRates) {
        double totalUsers = 0;
        for (float growthRate : growthRates)
            totalUsers += Math.pow(growthRate, mid);

        return (int) totalUsers >= billion;
    }


    int getBillionUsersDay(float[] growthRates) {
        int low = 1, high = Integer.MAX_VALUE;
        while (low < high) {
            int mid = low + (high - low) / 2; // won't overflow int
            if (growthRateHelper(mid, growthRates)) // binary search
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }


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
        float[] test_1 = {1.1f, 1.2f, 1.3f};
        int expected_1 = 79;
        int output_1 = getBillionUsersDay(test_1);
        check(expected_1, output_1);

        float[] test_2 = {1.01f, 1.02f};
        int expected_2 = 1047;
        int output_2 = getBillionUsersDay(test_2);
        check(expected_2, output_2);


        // Add your own test cases here

    }

    public static void main(String[] args) {
        new BillionUsers().run();
    }

}
