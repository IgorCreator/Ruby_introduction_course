package hackaton;

/*
* Given an integer M and an array A consisting of N non-negative integers,
* which are not greater than M, returns the value (or one of the values)
* that occurs most often in this array.
* */

public class VestmarkEx1 {
    static public int solution(int M, int[] A) {
        int N = A.length;
        int[] count = new int[M + 1];
        for (int i = 0; i <= M; i++)
            count[i] = 0;
        int maxOccurence = Integer.MIN_VALUE; //Change made in this line
        int index = 0;  //Change made in this line
        for (int i = 0; i < N; i++) {
            if (A[i]<=M && count[A[i]] > 0) {  //Change made in this line
                int tmp = count[A[i]];
                if (tmp > maxOccurence) {
                    maxOccurence = tmp;
                    index = i;
                }
                count[A[i]] = tmp + 1;
            } else {
                count[A[i]]=1;
            }
        }
        return N>0?A[index]:0;  //Change made in this line
    }

    public static void main(String[] args) {
      int[] A = {1, 2, 3, 1, 3, 1, 3, 3} ;
        System.out.println(solution(3, A));
    }
}
