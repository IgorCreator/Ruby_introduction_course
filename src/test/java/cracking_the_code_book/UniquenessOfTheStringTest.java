package cracking_the_code_book;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UniquenessOfTheStringTest {

    public static void main(String[] args) {
        UniquenessOfTheStringTest leetCodeSandBox = new UniquenessOfTheStringTest();

        assertTrue(leetCodeSandBox.isAllUniqueChars_v1("word"));
        assertTrue(leetCodeSandBox.isAllUniqueChars_v2("word"));
        assertTrue(leetCodeSandBox.isAllUniqueChars_v3("word"));
        assertTrue(leetCodeSandBox.isAllUniqueChars_v4("word"));

        assertFalse(leetCodeSandBox.isAllUniqueChars_v1("zoom"));
        assertFalse(leetCodeSandBox.isAllUniqueChars_v2("zoom"));
        assertFalse(leetCodeSandBox.isAllUniqueChars_v3("zoom"));
        assertFalse(leetCodeSandBox.isAllUniqueChars_v4("zoom"));
        assertFalse(leetCodeSandBox.isUniqueChars_bitMoving_solution("zombii"));
    }

    public boolean isAllUniqueChars_v1(String word){ //O(N)
        Set<Character> db = new HashSet<>();

        for(char ch: word.toCharArray()){ //O(N)
            if(db.contains(ch)) //O(1)
                return false;
            else
                db.add(ch);
        }

        return true;
    }

    public boolean isAllUniqueChars_v2(String word){ //O(N*N)
        char[] arr = word.toCharArray();

        for(int i = 0; i < arr.length; i++){ //O(N)
            char searcheable = arr[i];
            for(int j = i+1; j < arr.length; j++){ //O(N)
                if(searcheable == arr[j])
                    return false;
            }
        }
        return true;
    }

    public boolean isAllUniqueChars_v3(String word){ //0 (min (c, n))
        int[] arr = new int [26];

        for(char ch: word.toCharArray()){
            int found = (ch - 'a');

            if(arr[found] != 0)
                return false;
            else
                arr[found]++;
        }

        return true;
    }

    public boolean isAllUniqueChars_v4(String word){ //O(N*Log N)
        char[] arr = word.toCharArray();
        Arrays.sort(arr); //O(N*Log N)
        for(int i = 0; i < arr.length - 1; i++){ //O(N)
            if(arr[i] == arr[i+1])
                return false;
        }
        return true;
    }


    private boolean isUniqueChars_ShouldBe(String str) { // 0 (min (c, n))
        if (str.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i = 8; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) // Already found this char in string
                return false;

            char_set[val] = true;
        }
        return true;
    }

    // reduce our space usage by a factor of eight
    private boolean isUniqueChars_bitMoving_solution(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0){
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }
}
