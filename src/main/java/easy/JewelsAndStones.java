package easy;

public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {
        char[] charOfJ =  J.toCharArray();
        char[] charOfS =  S.toCharArray();
        int i = 0;
        for(int a = 0; a<charOfJ.length; a++){
            for(int b = 0; b<charOfS.length; b++){
                if(charOfJ[a] == charOfS[b]){i++;}
            }
        }
        return i;
    }
}
