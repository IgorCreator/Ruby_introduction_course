package easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> countOfWords = new HashSet<String>();
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for (String word : words) {
            countOfWords.add(transform(word, morse));
        }
        return countOfWords.size();
    }

    private String transform(String word, String[] morse) {
        char[] letter = word.toCharArray();
        StringBuilder output = new StringBuilder();
        for (int a=0; a<letter.length; a++) {
            char c = letter[a];
            output.append(morse[(int) c - 97]);
        }
        return output.toString();
    }
}
