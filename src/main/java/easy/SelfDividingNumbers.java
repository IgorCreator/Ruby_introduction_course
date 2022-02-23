package easy;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        for (int i = left; i<=right; i++) {
            if (checkForAvailibal(i)) {
                integerArrayList.add(i);
            }
        }
        return integerArrayList;
    }

    private boolean checkForAvailibal(int i) {
        char[] index = String.valueOf(i).toCharArray();
        for (int a =0 ; a<index.length; a++) {
            if (index[a] == '0' || i % Character.getNumericValue(index[a]) != 0) {
                return  false;
            }
        }
        return true;
    }
}
