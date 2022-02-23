package easy;

public class ToLowerCase {
    public String toLowerCase(String str) {
        char[] input = str.toCharArray();
        char[] output = input.clone();
        for(int a=0; a<input.length; a++){
            if('A'<=input[a] && input[a]<='Z'){
                output[a]= (char)(input[a]+32);
            }
        }
        return new String(output);
    }
}
