package top.xcphoenix.algorithm.lcof;

import java.util.Arrays;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/2/17 下午9:23
 */
public class Code12 {
    int[][] direct = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] map;
    boolean success = false;

    public boolean exist(char[][] board, String word) {
        int x = board.length;
        int y = board[0].length;
        if (x * y < word.length()) {
            return false;
        }
        map = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int x, int y, String word, int index) {
        if (index == word.length()) {
            success = true;
            return true;
        }
        if (x >= board.length || y >= board[0].length || x < 0 || y < 0 || map[x][y] == 1) {
            return false;
        }
        if (board[x][y] != word.charAt(index)) {
            return false;
        }
        System.out.printf("%d %d %d\n", x, y, index);
        // 标记我来过
        map[x][y] = 1;
        // 四个方向依次尝试
        for (int i = 0; i < 4; i++) {
            int newX = x + direct[i][0];
            int newY = y + direct[i][1];
            // 往里走
            if (dfs(board, newX, newY, word, index + 1)) {
                return true;
            }
        }
        // 我败了，并拔掉了杆子
        map[x][y] = 0;
        return false;
    }

    public static void main(String[] args) {
        Code12 code12 = new Code12();
        char[][] chars = new char[30][30];
        for (char[] aChar : chars) {
            Arrays.fill(aChar, 'a');
        }
        chars[29][29] = 'b';
        String word = "baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        code12.exist(chars, word);
    }


}
