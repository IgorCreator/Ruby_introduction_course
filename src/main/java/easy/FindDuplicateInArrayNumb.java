package easy;

public class FindDuplicateInArrayNumb {
    public int necessaryNumb(int[] numbers) {
        if (numbers.length != 0) {
            return getTotalSum(numbers) - getArithmeticProgressSum(numbers, numbers.length - 1);
        } else
            return 0;
    }

    private int getTotalSum(int[] numbers) {
        int total = 0;
        for (int i = 0; i < numbers.length; i++) {
            total += numbers[i];
        }
        return total;
    }

    //Count sum in arithmetic progression
    private int getArithmeticProgressSum(int[] numbers, int size) {
        int arithmSum;

        /* 1) sum_N = n*(2*a1+(n-1)*d)/2        */
        int diff = numbers[1] - numbers[0];
        arithmSum = size * (2 * numbers[0] + (size - 1) * diff) / 2;

        /* 2) sum_N = n*(a1+an)/2   because     an=a1+(n-1)*diff      */
        //int highestNumber = numbers[size - 1];
        //arithmSum = numbers.length*((numbers[0]+highestNumber)/2);

        return arithmSum;

    }
}