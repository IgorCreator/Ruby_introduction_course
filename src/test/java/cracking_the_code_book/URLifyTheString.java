package cracking_the_code_book;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class URLifyTheString {

    @Test
    public void test() {
        URLifyTheString urLifyTheString = new URLifyTheString();

        assertEquals("Mr%20John%20Smith", urLifyTheString.convertString_v1("  Mr John Smith   "));
        assertEquals("Mr%20John%20Smith", urLifyTheString.convertString_builder("Mr John Smith   "));

        assertEquals("Mr%20John%20Smith", urLifyTheString.convertString_inPlace("Mr John Smith    ".toCharArray(), 13));
    }


    //It's often easiest to modify strings by going from the end of the string to the beginning.
    // You might find you need to know the number of spaces. Can you just count them?
    public String convertString_inPlace(char[] inputArr, int trueLength){

        // calc amount of spaces in arr
        int spacesQty = 0;
        for (int i = 0; i < trueLength; i++) {
            if(inputArr[i] == ' ') spacesQty++;
        }

        int index = trueLength + spacesQty * 2; // compute how many extra characters we will have in the final string
        if (trueLength < inputArr.length) inputArr[trueLength] = '\0';
        for (int i = trueLength - 1; i >0; i--) {
            if (inputArr[i] == ' ') {
                inputArr[index - 1] = '0';
                inputArr[index - 2] = '2';
                inputArr[index - 3] = '%';
                index = index - 3;
            } else {
                inputArr[index - 1] = inputArr[i];
                index--;
            }
        }

        return new String(inputArr);
    }

    public String convertString_builder(String input){
        if(input.length() == 0) return input;

        char[] inputArr = input.toCharArray();

        StringBuilder sb = new StringBuilder();
        boolean isNoCharsSeen = true;
        for (int i = inputArr.length - 1; i >= 0 ; i--) {
            char ch = inputArr[i];

            if(ch == ' '){
                if (!isNoCharsSeen)
                    sb.insert(0, "%20") ;
            } else {
                isNoCharsSeen = false;
                sb.insert(0, inputArr[i]);
            }

        }
        return sb.toString();
    }

    public String convertString_v1(String input){
        String normilizedInput = input.trim();
        return normilizedInput.replaceAll(" ", "%20");
    }
}
