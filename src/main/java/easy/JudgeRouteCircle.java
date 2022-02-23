package easy;

public class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        int[] cordinats = {0,0};
        char[] array = moves.toCharArray();

        for (int index=0; index<array.length; index++) {
            if (array[index] == 'U') {
                cordinats[0] = cordinats[0] + 1;
            } else if(array[index] == 'D'){
                cordinats[0] = cordinats[0] - 1;
            } else if(array[index] == 'R'){
                cordinats[1] = cordinats[1] + 1;
            } else if(array[index] == 'L'){
                cordinats[1] = cordinats[1] - 1;
            }
        }

        if(cordinats[0] == 0 && cordinats[1] == 0){
            return true;
        } else return false;
    }
}