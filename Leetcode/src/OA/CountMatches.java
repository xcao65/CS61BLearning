package OA;

import java.util.List;

public class CountMatches {
    static int countMatches(List<String> grid1, List<String> grid2) {
        int m1 = grid1.size();
        int n1 = grid1.get(0).length();
        int m2 = grid2.size();
        int n2 = grid2.get(0).length();

        int m = Math.min(m1, m2);
        int n = Math.min(n1, n2);

        int res = 0;
        char[][] map1 = new char[m][n];
        char[][] map2 = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map1[i][j] = grid1.get(i).charAt(j);
                map2[i][j] = grid2.get(i).charAt(j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map1[i][j] == '1' && isMatch(i, j, m, n, map1, map2)) {
                    res++;
                }
            }
        }
        return res;
    }

    private static boolean isMatch(int i, int j, int m, int n, char[][] map1, char[][] map2) {
        //boundary conditions:
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return true;
        }
        if (map1[i][j] != map2[i][j]) {
            return false;
        } else {
            if (map1[i][j] == '1') {
                map1[i][j] = '2';
                map2[i][j] = '2';
                if (!isMatch(i - 1, j, m, n, map1, map2) || !isMatch(i + 1, j, m, n, map1, map2) ||
                        !isMatch(i, j - 1, m, n, map1, map2) || !isMatch(i, j + 1, m, n, map1, map2)) {
                    map1[i][j] = '1';
                    map2[i][j] = '1';
                    return false;
                }
            }
            return true;
        }
    }
}
