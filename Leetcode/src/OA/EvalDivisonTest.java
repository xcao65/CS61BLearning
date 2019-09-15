package OA;

import static org.junit.Assert.*;
import org.junit.Test;

public class EvalDivisonTest {
    @Test
    public void calEavlTest() {
        /*
        [["a","b"],["e","f"],["b","e"]]
[3.4,1.4,2.3]
[["b","a"],["a","f"],["f","f"],["e","e"],["c","c"],["a","c"],["f","e"]]
*/
        String[][] equations = new String[][] {{"a", "b"}, {"e", "f"}, {"b", "e"}};
        double[] values = new double[] {3.4, 1.4, 2.3};
        String[][] queries = new String[][] {{"b", "a"}};
    }
}
