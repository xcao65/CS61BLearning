package OA;

import static org.junit.Assert.*;
import org.junit.Test;

public class ImageMatchingTest {
    @Test
    public void getMatches() {
        ImageMatching matcher = new ImageMatching();
        char[][] grid1 = new char[][] {{'1', '1', '1'}, {'1', '0', '0'}, {'1', '0', '0'}};
        char[][] grid2 = new char[][] {{'1', '1', '1'}, {'1', '0', '0'}, {'1', '0', '1'}};
        assertEquals(1, matcher.getMatches(3, grid1, 3, grid2));
    }

    @Test
    public void getMatches2() {
        ImageMatching matcher = new ImageMatching();
        /*
        1 1 1 1
        0 0 0 1
        1 1 1 0
        0 0 0 0

        1 1 1
        0 0 0
        1 1 1

         */
        char[][] grid1 = new char[][] {{'1', '1', '1', '1'}, {'0', '0', '0', '1'}, {'1', '1', '1', '0'},
                {'0', '0', '0', '0'}};
        char[][] grid2 = new char[][] {{'1', '1', '1'}, {'0', '0', '0'}, {'1', '1', '1'}};
        assertEquals(1, matcher.getMatches(4, grid1, 3, grid2));
    }

}
