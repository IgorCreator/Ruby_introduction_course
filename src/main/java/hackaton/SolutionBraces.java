package hackaton;

import java.io.*;
import java.util.*;

public class SolutionBraces {
    // Complete the braces function below.
    static String[] braces(String[] values) {
        String [] strings = new String[values.length];
        for(int i = 0 ; i<values.length; i++){
            strings[i] = balancedParenthensies(values[i]);
            strings[i] = isBalanced(values[i]);
        }
        return strings;
    }

    private static String balancedParenthensies(String brackets) {
        // set matching pairs
        Map<Character, Character> braces = new HashMap<>();
        braces.put('(', ')');
        braces.put('[',']');
        braces.put('{','}');

        // if length of string is odd, then it is not balanced
        if (brackets.length() % 2 != 0) {
            return "NO";
        }

        Stack<Character> halfBraces = new Stack();
        for(char ch: brackets.toCharArray()) {
            if (braces.containsKey(ch)) {
                halfBraces.push(braces.get(ch));
            }

            else if(halfBraces.isEmpty() || ch != halfBraces.pop()) {
                return "NO";
            }
        }
        return "YES";
    }

    private static String isBalanced(String check) {
        Stack<Character> S = new Stack<Character>();
        for(int a = 0; a < check.length(); a++)
        {
            char let = check.charAt(a);
            if(let == '[' || let == '{' || let == '(')
                S.push(let);
            else if(let == ']' || let == '}' || let == ')')
            {
                if(S.empty())
                    return "NO";
                switch(let)
                {
                    // Opening square brace
                    case ']':
                        if (S.pop() != '[')
                            return "NO";
                        break;
                    // Opening curly brace
                    case '}':
                        if (S.pop() != '{')
                            return "NO";
                        break;
                    // Opening paren brace
                    case ')':
                        if (S.pop() != '(')
                            return "NO";
                        break;
                    default:
                        break;
                }
            }
        }
        if(S.empty())
            return "YES";
        return "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int valuesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] values = new String[valuesCount];

        for (int i = 0; i < valuesCount; i++) {
            String valuesItem = scanner.nextLine();
            values[i] = valuesItem;
        }

        String[] res = braces(values);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(res[i]);

            if (i != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
