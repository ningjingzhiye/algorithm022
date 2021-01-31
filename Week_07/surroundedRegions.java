public class Solution {

    private int row, col;

    //并查集
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        row = board.length;
        col = board[0].length;
        UnionFind uf = new UnionFind(row * col + 1);
        int rootNode = row * col;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //遇到O进行并查集操作合并
                if (board[i][j] == 'O') {
                    if (i == 0 || j == 0 || i == row - 1 || j == col - 1) {
                        uf.union(node(i, j), rootNode);
                    } else {
                        if (i > 0 && board[i - 1][j] == 'O') uf.union(node(i , j), node(i - 1, j));
                        if (i < row - 1 && board[i + 1][j] == 'O') uf.union(node(i, j), node(i + 1, j));
                        if (j > 0 && board[i][j - 1] == 'O') uf.union(node(i, j), node(i, j - 1));
                        if (j < col - 1 && board[i][j + 1] == 'O') uf.union(node(i, j), node(i, j + 1));
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!uf.isConnected(node(i, j), rootNode)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private int node(int i, int j) {
        return i * col + j;
    }

    class UnionFind {
        int[] parents;

        public UnionFind(int totalNodes) {
            parents = new int[totalNodes];
            for (int i = 0; i < totalNodes; i++) {
                parents[i] = i;
            }
        }

        void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                parents[root1] = root2;
            }
        }

        int find(int node) {
            while (parents[node] != node) {
                parents[node] = parents[parents[node]];
                node = parents[node];
            }
            return node;
        }

        boolean isConnected(int node1, int node2) {
            return find(node1) == find(node2);
        }
    }

}
