package top.xcphoenix.algorithm.leetcode;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/3/21 下午5:30
 */
public class Solution79 {

    public boolean exist(char[][] board, String word) {
        int x = board.length, y = board[0].length;
        if (word.length() > x * y) {
            return false;
        }
        int[][] record = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (dfs(board, record, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, int[][] record, int x, int y, String word, int count) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length
                || count >= word.length() || record[x][y] == 1 || word.charAt(count) != board[x][y]) {
            return false;
        }
        record[x][y] = 1;
        // System.out.println(">>> " + count);
        // print(board, record);
        if (count == word.length() - 1) {
            record[x][y] = 0;
            return word.charAt(count) == board[x][y];
        }
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != j && i != -j) {
                    int newX = x + i;
                    int newY = y + j;
                    if (dfs(board, record, newX, newY, word, count + 1)) {
                        return true;
                    }
                }
            }
        }
        record[x][y] = 0;
        return false;
    }

    public void print(char[][] board, int[][] record) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char lflag = record[i][j] == 0 ? ' ' : '[';
                char rflag = record[i][j] == 0 ? ' ' : ']';
                System.out.printf("%c%c%c", lflag, board[i][j], rflag);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "ABCB";
        System.out.println(new Solution79().exist(board, word));
    }

}
