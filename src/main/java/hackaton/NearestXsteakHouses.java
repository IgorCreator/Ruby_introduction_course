package hackaton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NearestXsteakHouses {

    static List<List<Integer>> nearestXsteakHouses(int totalSteakhouses,
                                            List<List<Integer>> allLocations,
                                            int numSteakhouses)
    {

        if(totalSteakhouses == numSteakhouses || allLocations.size() == 0) return allLocations;

        else{
            allLocations.sort((o1, o2) -> {
                double firstRoot = 0;
                double secondRoot = 0;
                for (Integer xy: o1) {
                    firstRoot += (Math.pow(xy, 2));
                }
                for (Integer xy: o2) {
                    secondRoot += (Math.pow(xy, 2));
                }

                double firstDist = Math.sqrt(firstRoot);
                double secondDist = Math.sqrt(secondRoot);

                if (firstDist == secondDist) {
                    return 0;
                } else if (firstDist > secondDist) {
                    return 1;
                } else if (firstDist < secondDist) {
                    return -1;
                }
                return 0;
            });

            List<List<Integer>> result = new ArrayList<>();
            for (int i=0; i<numSteakhouses; i++) {
                result.add(allLocations.get(i));

            }
            return result;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> input1 = new ArrayList<>();
        input1.add(Arrays.asList(1,-3));
        input1.add(Arrays.asList(1,2));
        input1.add(Arrays.asList(3,4));
        System.out.println(nearestXsteakHouses(3, input1,1));
        List<List<Integer>> input2 = new ArrayList<>();
        input2.add(Arrays.asList(3,6));
        input2.add(Arrays.asList(2,4));
        input2.add(Arrays.asList(5,3));
        input2.add(Arrays.asList(2,7));
        input2.add(Arrays.asList(1,8));
        input2.add(Arrays.asList(7,9));
        System.out.println(nearestXsteakHouses(6, input2,3));
    }
}
