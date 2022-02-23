package easy;

import java.util.*;

public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String sentencesA, String sentencesB) {
        Map<String, Integer> count = new HashMap();
        for (String word: sentencesA.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);
        for (String word: sentencesB.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);

        List<String> ans = new LinkedList();
        for (String word: count.keySet())
            if (count.get(word) == 1)
                ans.add(word);

        return ans.toArray(new String[ans.size()]);
    }
}