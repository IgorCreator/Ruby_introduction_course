package easy;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayByParity {
    public int[] sortArrayByParityWithNewJava(int[] inputMatrix) {
        return Arrays.stream(inputMatrix)
                .boxed()
                .sorted(Comparator.comparingInt(a -> a % 2))
                .mapToInt(i -> i)
                .toArray();
    }

    public int[] sortArrayByParity(int[] A) {
        Integer[] B = new Integer[A.length];
        for (int t = 0; t < A.length; ++t)
            B[t] = A[t];

        Arrays.sort(B, Comparator.comparingInt(a -> a % 2));

        for (int t = 0; t < A.length; ++t)
            A[t] = B[t];
        return A;
    }
}
