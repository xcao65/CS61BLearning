package OA;

import org.junit.Test;
import static org.junit.Assert.*;

public class VoteTest {
    @Test
    public void getMost() {
        Vote voter = new Vote();
        String[] votes = new String[] {"Zake", "aohn", "clark", "xlark", "John"};
        assertEquals("xlark", voter.getVote(votes));
    }
}
