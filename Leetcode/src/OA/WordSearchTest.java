package OA;

import org.junit.Test;
import static org.junit.Assert.*;

public class WordSearchTest {
    @Test
    public void existTest() {
        char[][] input = new char[][] {
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}};
        String word = "AAB";
        boolean exp = true;
        assertEquals(exp, WordSearch.exist(input, word));
    }

    @Test
    public void existTest2() {
        char[][] input = new char[][] {
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}};
        String word = "ABCESEEEFS";
        boolean exp = true;
        assertEquals(exp, WordSearch.exist(input, word));
    }
}
