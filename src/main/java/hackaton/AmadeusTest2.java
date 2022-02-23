package hackaton;

import java.util.Arrays;

public class AmadeusTest2 {

    /*
    * In the army, each soldier has an assigned rank.
    * A soldier of rank X has to report to (any) soldier of rank X + 1.
    * Many soldiers can report to the same superior. Write a function:
    * that, given an array ranks
    * consisting of soldiers' ranks, returns the number of soldiers
    * who can report to some superior.
    * */

    //ranks = [3, 4, 3, 0, 2, 2, 3, 0, 0], your function should return 5
    //ranks = [4, 2, 0], your function should return 0.
    //ranks = [4, 4, 3, 3, 1, 0], your function should return 3

    static int pointer = 0;
    public static int solution(int[] ranks) {
        int rez = 0;
        int array2d[][] = new int[ranks.length][2];

        ranks = sort(ranks);
         for (int x : ranks){
             //System.out.println(x);
         }


        array2d[pointer][0] = ranks[0];
        array2d[pointer][1] = 1;

        for(int i=1; i<ranks.length; i++){
            if(ranks[i] == ranks[i-1]){
                System.out.println("ranks[i] " + ranks[i]);
                System.out.println("ranks[i-1] " + ranks[i-1]);
                array2d[pointer][1] = array2d[pointer][1] + 1;
            }
            else {
                pointer++;
                array2d[pointer][0] = ranks[i];
                array2d[pointer][1] = array2d[pointer][1] + 1;
            }
        }
        pointer++;

        array2d = sort2d(array2d);

       for (int[] x : array2d)
       {
           for (int y : x)
           {
               System.out.print(y + " ");
           }
           System.out.println();
       }

        for(int i=0; i<array2d.length-1; i++){
            if((array2d[i][0] - array2d[i+1][0]) == 1){
                rez = array2d[i][1];
            }
        }

        return rez;
    }

    private static int[][] sort2d(int[][] input){
       int[] c = new int[2];
        for(int i=0; i<pointer; i++){
            for(int j=i; j<pointer; j++){
                if(input[i][1]<input[j][1]){
                    c = input[i];
                    input[i] = input[j];
                    input[j] = c;
                }
            }
        }
        return input;
    }

    private static int[] sort(int[] ranks){
        for(int i=0; i<ranks.length; i++){
            for(int j=0; j<ranks.length; j++){
                if( ranks[i] > ranks[j]) {
                    int temp;
                    temp = ranks[i];
                    ranks[i] = ranks[j];
                    ranks[j] = temp;
                }
            }
        }
        return ranks;
    }

    public static void main(String[] args) {
       int [] arrs = {3, 4, 3, 0, 2, 2, 3, 0, 0};
        System.out.println("rez:" + solution(arrs));
    }
}
