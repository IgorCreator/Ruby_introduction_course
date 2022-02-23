package fb;

import java.util.*;


/*
*
A bracket is any of the following characters: (, ), {, }, [, or ].
We consider two brackets to be matching if the first bracket is an open-bracket, e.g., (, {, or [, and the second bracket is a close-bracket of the same type. That means ( and ), [ and ], and { and } are the only pairs of matching brackets.
Furthermore, a sequence of brackets is said to be balanced if the following conditions are met:
The sequence is empty, or
The sequence is composed of two or more non-empty sequences, all of which are balanced, or
The first and last brackets of the sequence are matching, and the portion of the sequence without the first and last elements is balanced.
You are given a string of brackets. Your task is to determine whether each sequence of brackets is balanced. If a string is balanced, return true, otherwise, return false

* */

public class BalanceBrackets {

    boolean isBalanced(String s) {
        // Write your code here
        if(s.isEmpty()) return true;

        Stack<Character> openChars = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            switch(ch) {
                case ')':
                    if(openChars.empty() || openChars.pop() != '(') return false;
                    break;
                case ']':
                    if(openChars.empty() || openChars.pop() != '[') return false;
                    break;
                case '}':
                    if(openChars.empty() || openChars.pop() != '{') return false;
                    break;
                case '{':
                case '[':
                case '(':
                    openChars.push(ch);
                    break;
                default:
                    continue; // skipping any useless characters like space or letters
            }
        }
        return openChars.empty();

    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[" + str + "]");
    }

    public void run() {
        String s_1 = "{[(])}";
        boolean expected_1 = false;
        testCase(s_1, expected_1);

        String s_2 = "{{[[(())]]}}";
        boolean expected_2 = true;
        testCase(s_2, expected_2);

        testCase("{[()]}", true);
        testCase("{}()", true);
        testCase(")", false);
        testCase("", true);
        // Add your own test cases here

    }

    private void testCase(String input, boolean expected) {
        boolean output_2 = isBalanced(input);
        check(expected, output_2);
    }

    public static void main(String[] args) {
        new BalanceBrackets().run();
    }
}
