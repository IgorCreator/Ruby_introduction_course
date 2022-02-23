package cracking_the_code_book;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringRotationTest {

    public static void main(String[] args) {
        StringRotationTest stringRotationTest = new StringRotationTest();

        assertTrue(stringRotationTest.isSubString_v1("waterbottle", "erbottlewat"));
        assertFalse(stringRotationTest.isSubString_v1("waterbottle", "erbottlewot"));

        assertTrue(stringRotationTest.isSubString_v2("waterbottle", "erbottlewat"));
        assertFalse(stringRotationTest.isSubString_v2("waterbottle", "erbottlewot"));

        assertTrue(stringRotationTest.areRotations("waterbottle", "erbottlewat"));
        assertFalse(stringRotationTest.areRotations("waterbottle", "erbottlewot"));
    }

    public boolean isSubString_v1(String word, String blob){ //O(N+M)
        if (word.length() != blob.length()) return false;

        int[] tracker = new int[128];

        for(char ch: word.toCharArray()){ //O(M)
            int numericValue = Character.getNumericValue(ch);
            tracker[numericValue]++;
        }

        for(char ch: blob.toCharArray()){ //O(N)
            int numericValue = Character.getNumericValue(ch);
            tracker[numericValue]--;
        }

        for(int num: tracker){ //O(C)
            if(num != 0) return false;
        }

        return true;
    }

    //Hints: #34, #88, #104
    public boolean isSubString_v2(String word, String mixed){ //O(N)
        if (word.length() != mixed.length()) return false;

        String blob = mixed + mixed;
        char[] blobArr = blob.toCharArray();
        int blobCur = 0;
        int wordCur = 0;

        while(blobCur < blobArr.length){
            if(blobArr[blobCur] == word.charAt(wordCur)){
                while(wordCur < word.length()){
                    if(blobArr[blobCur] != word.charAt(wordCur)){
                        wordCur = 0;
                        break;
                    } else if( wordCur == word.length() - 1) {
                        return true;
                    }

                    wordCur++;
                    blobCur++;
                }
            }

            blobCur++;
        }

        return false;
    }

    boolean areRotations(String str1, String str2)
    {
        // There lengths must be same and str2 must be
        // a substring of str1 concatenated with str1.
        return (str1.length() == str2.length()) &&
                ((str1 + str1).contains(str2));
    }

}
