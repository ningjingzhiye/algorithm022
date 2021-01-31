import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private int row, col;

    //dfs
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        row = grid.length;
        col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = 0;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    //bfs
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i * col + j);
                    while (!queue.isEmpty()) {
                        int tmp = queue.remove();
                        int r = tmp / col;
                        int c = tmp % col;
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
        return count;
    }

}
