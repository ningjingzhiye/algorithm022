import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    // 层序遍历 / BFS算法
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            int tmp = Integer.MIN_VALUE;
            for (int i = 1; i <= size; i++) {
                TreeNode front = deque.poll();
                if (front != null) {
                    tmp = Math.max(tmp, front.val);
                }
                if (front.left != null) {
                    deque.offer(front.left);
                }
                if (front.right != null) {
                    deque.offer(front.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    // DFS算法
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> res, int level) {
        if (node == null) {
            return;
        }
        if (res.size() == level) {
            res.add(node.val);
        } else {
            res.set(level, Math.max(res.get(level), node.val));
        }
        dfs(node.left, res, level + 1);
        dfs(node.right, res, level + 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
