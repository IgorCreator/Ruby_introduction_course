package hackaton;

public class CodilityForAmadeusDemoTask {


    /* Write a function:
     * that, given an array A of N integers, returns
     * the smallest positive integer (greater than 0)
     * that does not occur in A.
     * */

    public static void main (String[] args)
    {
        int arr[] = { 2, 3, 7, 6, 8, -1, -10, 15 };

        int missing = findMissingNo(arr);

        System.out.println( "The smallest positive"
                + " missing number is " + missing);
    }


    static int findMissingNo(int[] A)
    {
        // to store current array element
        int val;

        // to store next array element in
        // current traversal
        int nextval;

        for (int i = 0; i < A.length; i++) {

            // if value is negative or greater
            // than array size, then it cannot
            // be marked in array. So move to
            // next element.
            if (A[i] <= 0 || A[i] > A.length)
                continue;

            val = A[i];

            // traverse the array until we
            // reach at an element which
            // is already marked or which
            // could not be marked.
            while (A[val - 1] != val) {
                nextval = A[val - 1];
                A[val - 1] = val;
                val = nextval;
                if (val <= 0 || val > A.length)
                    break;
            }
        }

        // find first array index which is
        // not marked which is also the
        // smallest positive missing
        // number.
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }

        // if all indices are marked, then
        // smallest missing positive
        // number is array_size + 1.
        return A.length + 1;
    }
}
