package cracking_the_code_book;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class PalindromPermutationTest {


    @Test
    public void test() {
        PalindromPermutationTest permutationTest = new PalindromPermutationTest();

        assertTrue(permutationTest.isPernatattionPalindrom("Tact Coa"));
        assertTrue(permutationTest.isPermutationOfPalindrome("Tact Coa"));

        assertFalse(permutationTest.isPernatattionPalindrom("Moon"));
        assertFalse(permutationTest.isPermutationOfPalindrome("Moon"));
    }

    private boolean isPernatattionPalindrom(String input) {
        HashMap<Character, Integer > sawLetters = new HashMap<>();

        char[] charArray = input.toLowerCase().toCharArray();
        int onlyLetters = 0;
        for (char ch : charArray) {
            if(ch == ' ') continue;
            sawLetters.put(ch, sawLetters.getOrDefault(ch, 0) + 1);
            onlyLetters++;
        }

        boolean sawOddLetter = false;
        for (Map.Entry<Character, Integer> entry : sawLetters.entrySet()) {
            if(entry.getValue() % 2 != 0){
                if(onlyLetters % 2 == 0)
                    return false;
                else { // sawLetters.size() % 2 != 0
                    if(sawOddLetter)
                        return false;

                    sawOddLetter = true;
                }
            }
        }

        return true;
    }

// Solution for book
    boolean isPermutationOfPalindrome(String phrase) {
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

/* Check that no more than one character has an odd count. */
    boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true ;
    }

    int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') -
                Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);

            if (x != -1) {
                table[x]++;
            }
        }
        return table;
    }
}
