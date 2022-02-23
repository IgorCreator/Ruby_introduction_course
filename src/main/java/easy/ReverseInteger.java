package easy;

import java.util.Arrays;

public class ReverseInteger {

    private char[] charArray;
    private boolean negative;

    //How it should be solved
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    //How I solved it(incorrect)
    public int reverseInt(int input) {
        String inputStr = String.valueOf(input);
        reverse(inputStr);
        checkOnFirstMinus();
        checkOnFirstZero();
        return charArrayToInt();
    }

    private void reverse(String inputStr){
        charArray = inputStr.toCharArray();
        negative = false;
        int begin=0;
        int end=charArray.length-1;
        char temp;
        while(end>begin){
            temp = charArray[begin];
            charArray[begin]=charArray[end];
            charArray[end] = temp;
            end--;
            begin++;
        }
    }

    private int charArrayToInt() {
        int result = 0;
        for (char aCharArray : charArray) {
            int digit = (int) aCharArray - (int) '0';
            //int digit = (int)charArray[i];
            result *= 10;
            result += digit;
        }
        if (negative) {
            result *= -1;
        }
        return result;
    }


    private void checkOnFirstMinus() {
        int lastChar = charArray.length - 1;
        if (charArray[lastChar] == '-') {
            negative = true;
            if (charArray[1] == '0') {
                deleteChar(charArray, 1,lastChar);
            } else {
                deleteChar(charArray, 0,lastChar);
            }
        }
    }

    private void checkOnFirstZero() {
        if (charArray[0] == '0') {
            deleteChar(charArray, 1,charArray.length);
        }
    }

    private void deleteChar(char[] original, int from, int to) {
        charArray =  Arrays.copyOfRange(original, from, to);
    }

}
