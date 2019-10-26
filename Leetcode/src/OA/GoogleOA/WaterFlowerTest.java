package OA.GoogleOA;

import org.junit.Test;
import static org.junit.Assert.*;

public class WaterFlowerTest {
    @Test
    public void getNumOfStepsTest1() {
        WaterFlower runner = new WaterFlower();
        int[] inputArr = {2, 4, 3, 3, 1};
        int cap = 4;
        int exp = 17;
        int res = runner.getNumOfSteps(inputArr, cap);
        assertEquals(exp, res);
        int resImpl = runner.getNumOfStepsImpl(inputArr, cap);
//        assertEquals(exp, resImpl);
    }

    @Test
    public void getNumOfStepsTest2() {
        WaterFlower runner = new WaterFlower();
        int[] inputArr = {2, 4, 3, 3, 1};
        int cap = 3;
        int exp = -1;
        int res = runner.getNumOfSteps(inputArr, cap);
        assertEquals(exp, res);
        int resImpl = runner.getNumOfStepsImpl(inputArr, cap);
//        assertEquals(exp, resImpl);
    }

    @Test
    public void getNumOfStepsTest3() {
        WaterFlower runner = new WaterFlower();
        int[] inputArr = {2, 4, 5, 1, 2};
        int cap = 6;
        int exp = 17;
        int res = runner.getNumOfSteps(inputArr, cap);
        assertEquals(exp, res);
        int resImpl = runner.getNumOfStepsImpl(inputArr, cap);
//        assertEquals(exp, resImpl);
    }

    @Test
    public void getNumOfStepsV2Test1() {
        WaterFlower runner = new WaterFlower();
        int[] inputArr = {2, 4, 5, 1, 2};
        int cap = 6;
        int res = runner.getNumOfStepsV2(inputArr, cap);
        assertEquals(17, res);
    }

    @Test
    public void getNumOfRefillsBothEndsTest1() {
        WaterFlower runner = new WaterFlower();
        int[] inputArr = {2, 4, 5, 1, 2};
        int cap1 = 5;
        int cap2 = 7;
        int exp = 3;
        int res = runner.getNumOfRefillsBothEnds(inputArr, cap1, cap2);
        assertEquals(exp, res);
        int resImpl = runner.getNumOfRefillsBothEndsImpl(inputArr, cap1, cap2);
//        assertEquals(exp, resImpl);
    }

    @Test
    public void getNumOfRefillsBothEndsTest2() {
        WaterFlower runner = new WaterFlower();
        int[] inputArr = {6, 4, 4, 5, 1, 2};
        int cap1 = 6;
        int cap2 = 7;
        int exp = 5;
        int res = runner.getNumOfRefillsBothEnds(inputArr, cap1, cap2);
        assertEquals(exp, res);
        int resImpl = runner.getNumOfRefillsBothEndsImpl(inputArr, cap1, cap2);
//        assertEquals(exp, resImpl);
    }

    @Test
    public void getNumOfRefillsBothEndsTest3() {
        WaterFlower runner = new WaterFlower();
        int[] inputArr = {6, 4, 5, 1, 5};
        int cap1 = 6;
        int cap2 = 7;
        int exp = 4;
        int res = runner.getNumOfRefillsBothEnds(inputArr, cap1, cap2);
        assertEquals(exp, res);
        int resImpl = runner.getNumOfRefillsBothEndsImpl(inputArr, cap1, cap2);
//        assertEquals(exp, resImpl);
    }
}
