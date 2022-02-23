package hackaton;

import java.util.ArrayList;
import java.util.List;
/*
 * Amazon question 1 Intern Fall 2014-2015
 *
 * A colony of eight houses, represented as cells, are arranged in a straight line. Each day every cell competes with its adjacent cells (neighbours). An integer value of 1 represents an active cell and value of 0 represents an inactive cell. If both the neighbours are either active or inactive, the cell becomes inactive the next day; otherwise it becomes active on the next day. The two cells on the ends have a single adjacent cell, so the other adjacent cell can be assumed to be always inactive. Even after updating the cell state, its previous state is considered for updating the state of other cells. The cell information of all cells should be updated simultaneously.
 *
 * Input
 * The input to the function/method consists of two arguments - state,
 * a list of integers representing the current state of cells.
 * days, an integer representing the number of days.
 *
 * Output
 * Return a list of integers representing the state of the cells after the given number of days.
 *
 * */

public class CellCompete {


    private static List<Integer> cellCompete(int[] input, int days)
    {
        List<Integer> result = new ArrayList<>();

        int[] states = new int[10]; //another array to copy value
        states[0]=0; //assumptions
        states[9]=0;//assumptions
        for (int a=1;a<=input.length;a++){
            states[a]=input[a-1];
        }

        for (int i=0;i<days;i++){
            int[] u = new int[10];
            for (int b=0;b<10;b++){
                u[b]=states[b];
            }

            for(int j=1;j<9;j++){
                if(u[j-1]==u[j+1]){ //comparing the value of the neighbouring cells of u[]
                    states[j]=0; //changing value of cell according to condition
                }
                else
                    states[j]=1;
            }
        }

        for (int i=1;i<states.length;i++){
            result.add(states[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int days1 = 1;
        int cells1[]={1,0,0,0,0,1,0,0}; //array to pass through function
        System.out.println(cellCompete(cells1, days1));

        int days2 = 2;
        int cells2[]={1,1,1,0,1,1,1,1};
        System.out.println(cellCompete(cells2, days2));
    }
}
