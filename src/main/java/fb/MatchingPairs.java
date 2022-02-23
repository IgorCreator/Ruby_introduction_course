package fb;

import java.util.*;

/*
Given two strings s and t of length N, find the maximum number of possible matching pairs in strings s and t after
swapping exactly two characters within s.
A swap is switching s[i] and s[j], where s[i] and s[j] denotes the character that is present at the ith and jth index of s, respectively.

The matching pairs of the two strings are defined as the number of indices for which s[i] and t[i] are equal.

Note: This means you must swap two characters at different indices.
* */

class MatchingPairs {

    // Add any helper functions you may need here


    //int matchingPairs(String s, String t) {
    //  // Write your code here
    //  if(s.length() != t.length()) return -1;
    //
    //  //Map<Integer, Integer> commonCharsByPositions = new HashMap<>();
    //  List<Integer> mismatchPositions = new ArrayList<>();
    //
    //
    //  int commonLettersCounter = 0;
    //  for(int i = 0; i < s.length(); i++){
    //    if(s.charAt(i) == t.charAt(i)) commonLettersCounter++;
    //    else {
    //      //commonCharsByPositions.put(i, commonLettersCounter);
    //      mismatchPositions.add(i);
    //    }
    //  }
    //
    //  // logic if list empty or has 1 el
    //  if(mismatchPositions.size() == 0){
    //    return commonLettersCounter - 2;
    //  } else if(mismatchPositions.size() == 1){
    //    return commonLettersCounter - 1;
    //  } else {
    //      for(int i = 0; i < mismatchPositions.size() - 1; i++){
    //        char char_s = s.charAt(mismatchPositions.get(i));
    //
    //        for(int j = i + 1; j < mismatchPositions.size(); j++){
    //          char char_t = t.charAt(mismatchPositions.get(j));
    //
    //          if(char_s == char_t)
    //            return commonLettersCounter + 2;
    //        }
    //      }
    //  }
    //
    //  return commonLettersCounter;
    //}

    int matchingPairs(String s, String t) {

        Set<String> unMatched = new HashSet<>();
        Set<Character> matched = new HashSet<>();
        int commonLettersCounter = 0;
        boolean isDup = false;

        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == t.charAt(i)) {
                commonLettersCounter++;
                if(matched.contains(s.charAt(i))) {
                    isDup = true;
                }
                matched.add(s.charAt(i));
            } else {
                unMatched.add(s.charAt(i) + "" + t.charAt(i));
            }
        }

        if(commonLettersCounter == s.length()) {
            return isDup ? commonLettersCounter :  commonLettersCounter - 2;
        }

        if(commonLettersCounter == s.length() - 1) {
            String onlyUnmatched = (String)unMatched.toArray()[0];
            if(isDup || matched.contains(onlyUnmatched.charAt(0)) || matched.contains(onlyUnmatched.charAt(1)))
                return commonLettersCounter;
            return commonLettersCounter - 1;
        }

        for(String um:unMatched) {
            if(unMatched.contains(um.charAt(1)+""+um.charAt(0))) {
                return commonLettersCounter + 2;
            }
        }

        Set<Character> unMatchedS = new HashSet<>();
        Set<Character> unMatchedT = new HashSet<>();

        for(String um : unMatched) {
            if(unMatchedS.contains(um.charAt(1)) || unMatchedT.contains(um.charAt(0))) {
                return commonLettersCounter + 1;
            }
            unMatchedS.add(um.charAt(0));
            unMatchedT.add(um.charAt(1));
        }
        return commonLettersCounter;
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
        helperTests("abcde", "adcbe", 5);
        helperTests("abcd", "abcd", 2);
        helperTests("abcdiabcdefgh", "abcdoabcdefhg", 12);
        helperTests("abcdiabcdefzx", "abcdoabcdefhg", 10);
        helperTests("mnat", "mnot", 2);
        helperTests("mno", "mno", 1);

        helperTests("aa", "aa", 2);
        helperTests("abcd", "abcd", 2);

        helperTests("ax" , "ay" , 0);
        helperTests("axb", "ayb", 1);
        helperTests("axa", "aya", 1); // still fails
        helperTests("abx", "abb", 2);
        helperTests("abb", "axb", 2);
        helperTests("ax" , "ya" , 1);
        helperTests("abc" , "adb" , 2);
    }

    private void helperTests(String s, String t, int expected){
        int output = matchingPairs(s, t);
        check(expected, output);
    }

    public static void main(String[] args) {
        new MatchingPairs().run();
    }
}
