package OA;

import org.junit.Test;
import static org.junit.Assert.*;

public class PowerTest {
    @Test
    public void powerTest() {
        double exp = Math.pow(2.00000, -2147483648);
        double act = Power.pow(2.00000, -2147483648);
        assertEquals(exp, act, 0);
    }

}
