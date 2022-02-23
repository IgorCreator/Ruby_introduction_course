package fb;


/*
* You've devised a simple encryption method for alphabetic strings that shuffles the characters in such a way that the resulting string is hard to quickly read, but is easy to convert back into the original string.
When you encrypt a string S, you start with an initially-empty resulting string R and append characters to it as follows:
Append the middle character of S (if S has even length, then we define the middle character as the left-most of the two central characters)
Append the encrypted version of the substring of S that's to the left of the middle character (if non-empty)
Append the encrypted version of the substring of S that's to the right of the middle character (if non-empty)
For example, to encrypt the string "abc", we first take "b", and then append the encrypted version of "a" (which is just "a") and the encrypted version of "c" (which is just "c") to get "bac".
If we encrypt "abcxcba" we'll get "xbacbca". That is, we take "x" and then append the encrypted version "abc" and then append the encrypted version of "cba".0
*
* */

public class EncryptedWords {

    String findEncryptedWord(String s) {
        // Write your code here
        if (s.isEmpty()) return "";
        if (s.length() == 1) return s;

        StringBuilder sb = new StringBuilder();
        processEnc(s, 0, s.length() - 1, sb);
        return sb.toString();
    }

    void processEnc(String s, int start, int end, StringBuilder sb) {
        if(start == end) {
            sb.append(s.charAt(start));
            return;
        } else if(start > end)
            return;

        int mid = (start + end) / 2;
        sb.append(s.charAt(mid));
        processEnc(s, start, mid - 1, sb);
        processEnc(s, mid + 1, end, sb);
    }

    String findEncryptedWord_v2_short(String s) {
        if (s.isEmpty()) return "";
        if (s.length() == 1) return s;
        int mid = (s.length() % 2 != 0) ? s.length() / 2 : (s.length() / 2 - 1);
        return s.charAt(mid) + findEncryptedWord(s.substring(0, mid)) +
                findEncryptedWord(s.substring(mid + 1));
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;

    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        assertionHelper("abc", "bac");
        assertionHelper("abcd", "bacd");
        assertionHelper("abcxcba", "xbacbca");
        assertionHelper("fb", "eafcobok");
    }

    public void assertionHelper(String s, String expectedRes){
        String outputRes = findEncryptedWord(s);
        check(expectedRes, outputRes);
    }

    public static void main(String[] args) {
        new EncryptedWords().run();
    }
}

