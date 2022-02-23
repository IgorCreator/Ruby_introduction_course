package cracking_the_code_book;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PermuatationOfTheStr {

    @Test
    public void verifyIfPermutation(){
        PermuatationOfTheStr sol = new PermuatationOfTheStr();

        assertTrue(sol.isPermutation_v1("abc", "cba"));
        assertTrue(sol.isPermutation_v2("abc", "cba"));

        assertFalse(sol.isPermutation_v1("sol", "cba"));
        assertFalse(sol.isPermutation_v2("sol", "cba"));
    }

    public boolean isPermutation_v1(String wordOne, String wordTwo){  //O(N * log N)
        if(wordOne.length() != wordTwo.length()) return false;

        char[] list1 = wordOne.toCharArray();
        char[] list2 = wordTwo.toCharArray();
        Arrays.sort(list1);
        Arrays.sort(list2);
        int i = 0;
        while(i < list1.length){
            if(list1[i] != list2[i])
                return false;

            i++;
        }

        return true;
    }

    public boolean isPermutation_v2(String wordOne, String wordTwo){  //O(min(c,N))
        if(wordOne.length() != wordTwo.length()) return false;

        int[] db = new int[26];

        for(char ch: wordOne.toCharArray()){    // O (N)
            int i = ch - 'a';
            db[i]++;
        }

        for(char ch: wordTwo.toCharArray()){    // O (N)
            int i = ch - 'a';
            db[i]--;
        }

        for(int i: db){                         // O (c)
            if(i != 0) return false;
        }
        return true;
    }
}
