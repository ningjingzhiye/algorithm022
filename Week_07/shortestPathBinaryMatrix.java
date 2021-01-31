import java.util.*;

public class Solution {

    private int n;

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null) {
            return -1;
        }
        if (grid.length < 2) {
            return grid.length;
        }
        n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        int[][] dir = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1},
                {-1, 1}, {-1, -1}, {1, -1}, {1, 1}
        };
        Node start = new Node(0, 0, grid[0][0] = 1);
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int step = grid[node.x][node.y];
            for (int[] d : dir) {
                int x = node.x + d[0];
                int y = node.y + d[1];
                if (x == n - 1 && y == n - 1) {
                    return step + 1;
                }
                if (x < 0 || x >= n || y < 0 || y >= n) {
                    continue;
                }
                if (grid[x][y] == 0 || grid[x][y] > step + 1) {
                    Node next = new Node(x, y, grid[x][y] = step + 1);
                    queue.offer(next);
                }
            }
        }
        return -1;
    }

    class Node implements Comparable<Node> {
        int x;
        int y;
        int f;

        public Node(int x, int y, int step) {
            this.x = x;
            this.y = y;
            int distance = Math.max(n - 1 - x, n - 1 - y);
            this.f = distance + step;
        }

        @Override
        public int compareTo(Node o) {
            return this.f - o.f;
        }
    }

}
