package easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class UncommonWordsFromTwoSentencesTest {

    @Test
    public void uncommonFromSentencesTest() {
        UncommonWordsFromTwoSentences sentences = new UncommonWordsFromTwoSentences();

        String inputACaseA = "this apple is sweet";
        String inputBCaseA = "this apple is sour";
        String[] outputCaseA = {"sweet","sour"};
        assertArrayEquals(outputCaseA, sentences.uncommonFromSentences(inputACaseA,inputBCaseA));

        String inputACaseB = "apple apple";
        String inputBCaseB = "banana";
        String[] outputCaseB = {"banana"};
        assertArrayEquals(outputCaseB, sentences.uncommonFromSentences(inputACaseB, inputBCaseB));
    }
}