package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UniqueMorseCodeWordsTest {

    @Test
    public void uniqueMorseRepresentationsTest() {
        String[] words = {"gin", "zen", "gig", "msg"};
        assertEquals(2, new UniqueMorseCodeWords().uniqueMorseRepresentations(words));
        ;
    }
}
