package OA;

import java.util.ArrayList;
import java.util.List;

public class Matrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        //Update upper left bottom right boundary
        int up = 0, left = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
        while (up <= bottom && left <= right) {
            int count = 0;
            for (int i = up, j = left; j <= right; j++) {
                count++;
                res.add(matrix[i][j]);
            }
            if (count == 0) return res;
            count = 0;
            for (int i = up + 1, j = right; i <= bottom; i++) {
                res.add(matrix[i][j]);
                count++;
            }
            if (count == 0) return res;
            count = 0;
            for (int i = bottom, j = right - 1; j >= left; j--) {
                res.add(matrix[i][j]);
                count++;
            }
            if (count == 0) return res;
            count = 0;
            for (int i = bottom - 1, j = left; i > up; i--) {
                res.add(matrix[i][j]);
                count++;
            }
            if (count == 0) return res;
            bottom--;
            up++;
            left++;
            right--;
        }
        return res;
    }
}
