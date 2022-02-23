package fb;

import java.util.*;


/*
There are n guests attending a dinner party, numbered from 1 to n. The ith guest has a height of arr[i-1] inches.
The guests will sit down at a circular table which has n seats, numbered from 1 to n in clockwise order around the table. As the host, you will choose how to arrange the guests, one per seat. Note that there are n! possible permutations of seat assignments.
Once the guests have sat down, the awkwardness between a pair of guests sitting in adjacent seats is defined as the absolute difference between their two heights. Note that, because the table is circular, seats 1 and n are considered to be adjacent to one another, and that there are therefore n pairs of adjacent guests.
The overall awkwardness of the seating arrangement is then defined as the maximum awkwardness of any pair of adjacent guests. Determine the minimum possible overall awkwardness of any seating arrangement.
* */

class SeatingArrangements {

    int minOverallAwkwardness(int[] arr) {
        Arrays.sort(arr);

        int[] table = new int[arr.length];
        int left = 0;
        int right = arr.length-1;
        //Explanation:
        //Goal to minimizing height differences, imagine an unsorted list [a,b,c,d,e] you will be limited by the MAX difference occurring among 3 items when trying to minimize that difference.
        //Example: [2,4,6,20,40]... no matter what, 40 has to be next to 2 numbers. So we aren't limited by the neighbors [20,40] but instead by [6,40]
        //Example: [2,4,7,7,7]... it's harder to see, but 2,4,7 will be the limiting set and 5 would be the max height difference.
        //So we will always be limited by the skip-an-item pairs in the sorted list. Sorting helps us minimize the differences, and then we want to find the max.

        //SO solution start filling the table from both ends, so that two tallest will be at the 0 and n-1 index there by minimizing the awkwardness
        for(int i=arr.length-1;i>=0;i--)
        {
            if(i%2==0)
                table[left++] = arr[i];
            else
                table[right--] = arr[i];
        }

        int maxDiff = 0;
        for(int i=0; i < arr.length - 1; i++){
            maxDiff = Math.max(Math.abs(table[i] - table[i+1]), maxDiff);
        }
        maxDiff = Math.max(Math.abs(arr[table.length - 1] - table[0]), maxDiff);
        return maxDiff;
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
        }
        else {
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
        int[] arr_1 = {5, 10, 6, 8};
        int expected_1 = 4;
        int output_1 = minOverallAwkwardness(arr_1);
        check(expected_1, output_1);

        int[] arr_2 = {1, 2, 5, 3, 7};
        int expected_2 = 4;
        int output_2 = minOverallAwkwardness(arr_2);
        check(expected_2, output_2);
    }

    public static void main(String[] args) {
        new SeatingArrangements().run();
    }
}