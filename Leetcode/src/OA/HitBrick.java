package OA;

public class HitBrick {

    public static int[] hitBricks(int[][] grid, int[][] hits) {
        int[] results = new int[hits.length];
        for (int i = 0; i < hits.length; i++) {
            int x = hits[i][0];
            int y = hits[i][1];
            if (grid[x][y] == 0) {
                results[i] = 0;
                continue;
            } else {
                grid[x][y] = 0;
                int[][] backup = copyArray(grid);
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    grid = drop(x - 1, y, grid);
                }
                if (x + 1 < grid.length && grid[x + 1][y] == 1) {
                    grid = drop(x + 1, y, grid);
                }
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    grid = drop(x, y - 1, grid);
                }
                if (y + 1 < grid[0].length && grid[x][y + 1] == 1) {
                    grid = drop(x, y + 1, grid);
                }
                results[i] = calDiff(grid, backup);
            }
        }
        return results;
    }

    private static int calDiff(int[][] a, int[][] b) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != b[i][j]) sum++;
            }
        }
        return sum;
    }

    private static int[][] copyArray (int[][] input) {
        int[][] res = new int[input.length][input[0].length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                res[i][j] = input[i][j];
            }
        }
        return res;
    }

    private static int[][] drop(int x, int y, int[][] map) {
        if (x == 0) return map;
        map[x][y] = 0;

        int[][] grid1 = copyArray(map);
        if (x > 0 && map[x - 1][y] == 1) {

            grid1 = drop(x - 1, y, grid1);
            if (grid1[x - 1][y] == 1) {
                map[x][y] = 1;
                return map;
            }
        }

        int[][] grid2 = copyArray(map);
        if (x < map.length - 1 && map[x + 1][y] == 1) {
            grid2 = drop(x + 1, y, grid2);
            if (grid2[x + 1][y] == 1) {
                map[x][y] = 1;
                return map;
            }
        }

        int[][] grid3 = copyArray(map);
        if (y > 0 && map[x][y - 1] == 1) {
            grid3 = drop(x, y - 1, grid3);
            if (grid3[x][y - 1] == 1) {
                map[x][y] = 1;
                return map;
            }
        }

        int[][] grid4 = copyArray(map);
        if (y < map[0].length - 1 && map[x][y + 1] == 1) {
            grid4 = drop(x, y + 1, grid4);
            if (grid4[x][y + 1] == 1) {
                map[x][y] = 1;
                return map;
            }
        }
        int[][] res = mergeMap(grid1, grid2, grid3, grid4);
        return res;
    }

    public static int[][] mergeMap(int[][] map1, int[][] map2, int[][] map3, int[][] map4) {
        int[][] res = new int[map1.length][map1[0].length];
        for (int i = 0; i < map1.length; i++) {
            for (int j = 0; j < map1[0].length; j++) {
                res[i][j] = (map1[i][j] == 0 || map2[i][j] == 0 || map3[i][j] == 0 || map4[i][j] == 0) ? 0 : 1;
            }
        }
        return res;
    }
}
