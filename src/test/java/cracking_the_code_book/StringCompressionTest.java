package cracking_the_code_book;

import static org.junit.Assert.assertEquals;

public class StringCompressionTest {

    public static void main(String[] args) {
        StringCompressionTest copressor = new StringCompressionTest();

        assertEquals(copressor.zip("aabcccccaaa"), "a2b1c5a3");
        assertEquals(copressor.zip("aaaaaaaaa"), "a9");
        assertEquals(copressor.zip("abcdf"), "abcdf"); //a1b1c1d1f1
    }

    private String zip(String input) {
        if(input.length() == 0) return "";

        StringBuilder sb = new StringBuilder();
        char[] inputData = input.toCharArray();

        char character = inputData[0];
        int count = 1;
        for (int i = 1; i < inputData.length; i++){
            if(character == inputData[i]){
                count++;
            } else {
                sb.append(character).append(count);
                count = 1;
                character = inputData[i];
            }
        }
        sb.append(character).append(count);

        String res = sb.toString();
        System.out.println(res);
        return input.length() < res.length() ? input : res;
    }

    // Book solution no need to check if not copresseed shorter
    private String compress (String str) {
        /* Check final length and return input string if it would be longer. */
        int finalLength = countCompression(str);
        if (finalLength >= str.length()) return str;

        StringBuilder compressed = new StringBuilder(finalLength); // initial capacity
        int countConsecutive = 0;
        for (int i = 0; i < str . length(); i++) {
            countConsecutive++;

            /* If next character is different than current, append this char to result. */
            if ( i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.toString();
    }

    int countCompression(String str) {
        int compressedLength = 0;
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            /* If next character is different than current, increase the length. */
            if ( i + 1>= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedLength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }
        return compressedLength;
    }
}



