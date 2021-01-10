import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /**
     * 使用bfs算法
     * */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    grid[i][j] = '0';
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i * col + j);
                    while (!queue.isEmpty()) {
                        int id = queue.remove();
                        int r = id / col;
                        int c = id % col;
                        if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                            queue.add((r - 1) * col + c);
                            grid[r - 1][c] = '0';
                        }
                        if (r + 1 < row && grid[r + 1][c] == '1') {
                            queue.add((r + 1) * col + c);
                            grid[r + 1][c] = '0';
                        }
                        if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                            queue.add(r * col + c - 1);
                            grid[r][c - 1] = '0';
                        }
                        if (c + 1 < col && grid[r][c + 1] == '1') {
                            queue.add(r * col + c + 1);
                            grid[r][c + 1] = '0';
                        }
                    }
                }
            }
        }
        return res;
    }

}
