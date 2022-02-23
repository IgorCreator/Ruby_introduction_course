package hackaton;

/*
 * Amazon question 2 Intern Fall 2014-2015
 *
 * The greatest common divisor (GCD), also called highest common factor (HCF) of N numbers is the largest positive integer that divides all numbers without giving a remainder.
 * Write an algorithm to determine the GCD of N positive integers.
 *
 * Input
 * The input to the function/method consists of two arguments - num
 * , an integer representing the number of positive integers (N).
 * arr, , a list of positive integers.
 *
 * Output
 * Return an integer representing the GCD of the given positive integers.
 *
 * */

public class GeneralizedGCD {

    private static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    private static int generalizedGCD(int num, int[] arr)
    {
        int result = arr[0];
        for (int i = 1; i < num; i++)
            result = gcd(arr[i], result);

        return result;
    }

    public static void main(String[] args) {
        int nums1 = 5;
        int cells1[]={2,3,4,5,6}; //array to pass through function
        System.out.println(generalizedGCD(nums1,cells1));

        int nums2 = 2;
        int cells2[]={2,4,6,8,10};
        System.out.println(generalizedGCD(nums2, cells2));
    }
}
