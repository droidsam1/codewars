import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TopWordsTest {

    @Test
    void shouldReturnEmptyWhenEmptyInput() {

        var topWords = TopWords.top3("");

        assertNotNull(topWords);
        assertTrue(topWords.isEmpty());
    }

    @Test
    void shouldReturnTheOnlyWordWhenInputIsOnlyWord() {

        var topWords = TopWords.top3("A");

        assertNotNull(topWords);
        assertEquals(1, topWords.size());
    }

    @Test
    void shouldReturnLowerCaseWords() {

        var topWords = TopWords.top3("A");

        assertNotNull(topWords);
        assertEquals(topWords.stream().map(String::toLowerCase).collect(Collectors.toList()), topWords);
    }

// TODO: droidsam to enable late in development
//    @Test
//    public void sampleTests() {
//        assertEquals(Arrays.asList("e", "d", "a"), TopWords.top3("a a a  b  c c  d d d d  e e e e e"));
//        assertEquals(Arrays.asList("e", "ddd", "aa"), TopWords.top3("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e"));
//        assertEquals(Arrays.asList("won't", "wont"), TopWords.top3("  //wont won't won't "));
//        assertEquals(List.of("e"), TopWords.top3("  , e   .. "));
//        assertEquals(List.of(), TopWords.top3("  ...  "));
//        assertEquals(List.of(), TopWords.top3("  '  "));
//        assertEquals(List.of(), TopWords.top3("  '''  "));
//        assertEquals(Arrays.asList("a", "of", "on"), TopWords.top3(Stream
//                .of("In a village of La Mancha, the name of which I have no desire to call to",
//                        "mind, there lived not long since one of those gentlemen that keep a lance",
//                        "in the lance-rack, an old buckler, a lean hack, and a greyhound for",
//                        "coursing. An olla of rather more beef than mutton, a salad on most",
//                        "nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra",
//                        "on Sundays, made away with three-quarters of his income.")
//                .collect(Collectors.joining("\n"))));
//    }
}