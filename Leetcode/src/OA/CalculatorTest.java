package OA;

import org.junit.Test;

public class CalculatorTest {
    @Test
    public void test1() {
        Calculator cal = new Calculator();
        cal.calculate("1 + 1");
    }
}
