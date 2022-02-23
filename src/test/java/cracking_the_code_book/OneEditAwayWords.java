package cracking_the_code_book;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OneEditAwayWords {

    @Test
    public void test() {
        OneEditAwayWords oneEditAwayWords = new OneEditAwayWords();

        assertTrue(oneEditAwayWords.isOneEditAway("pale", "ple"));
        assertTrue(oneEditAwayWords.isOneEditAway("pales", "pale"));
        assertTrue(oneEditAwayWords.isOneEditAway("pale", "bale"));
        assertFalse(oneEditAwayWords.isOneEditAway("pale", "bake"));

        assertTrue(oneEditAwayWords.oneEditAway("pale", "ple"));
        assertTrue(oneEditAwayWords.oneEditAway("pales", "pale"));
        assertTrue(oneEditAwayWords.oneEditAway("pale", "bale"));
        assertFalse(oneEditAwayWords.oneEditAway("pale", "bake"));

        assertTrue(oneEditAwayWords.oneEditAway_exlanatory("pale", "ple"));
        assertTrue(oneEditAwayWords.oneEditAway_exlanatory("pales", "pale"));
        assertTrue(oneEditAwayWords.oneEditAway_exlanatory("pale", "bale"));
        assertFalse(oneEditAwayWords.oneEditAway_exlanatory("pale", "bake"));
    }

    private boolean isOneEditAway(String word1, String word2) { //(O(mk)) wher m = word1.length() and n = word2.length()

        // Vector matrix for finding diffirance
        //int[][] db = new int[word1.length()][word2.length()];

        int similarityWeight = 0;
        for (int i = 0; i < word1.length(); i++) {            //(O(m)
            for (int j = 0; j < word2.length(); j++) {        //(O(k)
                if (word1.charAt(i) == word2.charAt(j)) {
                    //db[i][j] = 1;
                    similarityWeight++;
                }
            }
        }
        return Math.max(word1.length(), word2.length()) - similarityWeight == 1;
    }

    // checking on exact matching sequence of the words
    boolean oneEditAway(String first, String second) {
        /* Length checks. */
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        /* Get shorter and longer string */
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;
        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;

        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {

                /* Ensure that this is the first difference found. */
                if (foundDifference) return false;
                foundDifference = true;

                if (s1.length() == s2.length()) { // On replace, move shorter pointer
                    index1++;
                }
            } else {
                index1++; // If matching, move shorter pointer
            }
            index2++; // Always move pointer for longer string
        }
        return true;
    }



    boolean oneEditAway_exlanatory(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) {
            return oneEditlnsert(first, second);
        } else if (first.length() - 1 == second.length()) {
            return oneEditlnsert(second, first);
        }
        return false;
    }

    boolean oneEditReplace(String s1, String s2) {
        boolean foundDifference = false;
        for ( int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    /* Check if you can insert a character into s1 to make s2. */
    boolean oneEditlnsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }
}
