package OA.GoogleOA;

import org.junit.Test;
import static org.junit.Assert.*;

public class WaterFlowerTest {
    @Test
    public void getNumOfStepsTest1() {
        WaterFlower runner = new WaterFlower();
        int[] inputArr = {2, 4, 3, 3, 1};
        int cap = 4;
        int res = runner.getNumOfSteps(inputArr, cap);
        assertEquals(res, 17);
    }

    @Test
    public void getNumOfStepsTest2() {
        WaterFlower runner = new WaterFlower();
        int[] inputArr = {2, 4, 3, 3, 1};
        int cap = 3;
        int res = runner.getNumOfSteps(inputArr, cap);
        assertEquals(res, -1);
    }

    @Test
    public void getNumOfStepsTest3() {
        WaterFlower runner = new WaterFlower();
        int[] inputArr = {2, 4, 5, 1, 2};
        int cap = 6;
        int res = runner.getNumOfSteps(inputArr, cap);
        assertEquals(res, 17);
    }

    @Test
    public void getNumOfStepsV2Test1() {
        WaterFlower runner = new WaterFlower();
        int[] inputArr = {2, 4, 5, 1, 2};
        int cap = 6;
        int res = runner.getNumOfStepsV2(inputArr, cap);
        assertEquals(res, 17);
    }
}
