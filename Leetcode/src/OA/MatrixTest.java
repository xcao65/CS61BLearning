package OA;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MatrixTest {

    @Test
    public void test1() {
        int[][] input = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        List<Integer> res = Matrix.spiralOrder(input);
        List<Integer> exp = new ArrayList<>();
        exp.add(1);
        exp.add(2);
        exp.add(3);
        exp.add(6);
        exp.add(9);
        exp.add(8);
        exp.add(7);
        exp.add(4);
        exp.add(5);

    }
}
