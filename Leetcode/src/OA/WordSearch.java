package OA;

public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        if (word == null) return false;
        char[] wl = word.toCharArray();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (recurFind(i, j, m, n, wl, 0, board)) return true;
            }
        }
        return false;
    }

    private static boolean recurFind(int i , int j, int m, int n, char[] wl, int index, char[][] dup) {
        if (index == wl.length) return true;
        if (i < 0 || i >= m) {
            return false;
        }
        if (j < 0 || j >= n) {
            return false;
        }
        if (dup[i][j] == '\u0000') {
            return false;
        }
        if (dup[i][j] != wl[index]) {
            return false;
        }
        char temp = dup[i][j];
        dup[i][j] = '\u0000';
        boolean res = (recurFind(i - 1, j, m, n, wl, index + 1, dup) || recurFind(i + 1, j, m, n, wl, index + 1, dup)
        || recurFind(i, j - 1, m, n, wl, index + 1, dup) || recurFind(i, j + 1, m, n, wl, index + 1, dup));
        dup[i][j] = temp;
        return res;
    }
}
