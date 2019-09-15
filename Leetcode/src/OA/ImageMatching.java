package OA;

public class ImageMatching {
    public int getMatches(int grid1_count, char[][] grid1, int grid2_count, char[][] grid2) {
        if (grid1_count == 0 || grid2_count == 0) return 0;
        int n = Math.min(grid1_count, grid2_count);
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] == '1' && recurFind(i, j, grid1, grid2, n)) res++;
            }
        }

        return res;
    }

    private boolean recurFind(int i, int j, char[][] grid1, char[][] grid2, int n) {
        //boundary condition:
        if (i >= n || j >= n) {
            if (grid1.length > n && grid1[i][j] != '0') {
                return false;
            }
            if (grid2.length > n && grid2[i][j] != '0') {
                return false;
            }
            return true;
        }
        if (i < 0 || j < 0) return true;

        if (grid1[i][j] != grid2[i][j]) {
            return false;
        } else {
            if (grid1[i][j] == '1') {
                grid1[i][j] = '2';
                grid2[i][j] = '2';
                if (!recurFind(i - 1, j, grid1, grid2, n) || !recurFind(i, j - 1, grid1, grid2, n) ||
                        !recurFind(i + 1, j, grid1, grid2, n) || !recurFind(i, j + 1, grid1, grid2, n)) {
                    grid1[i][j] = '1';
                    grid2[i][j] = '1';
                    return false;
                }
            }
            return true;
        }
    }
}
