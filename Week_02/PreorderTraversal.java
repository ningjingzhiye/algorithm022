import java.util.*;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // preOrder(root, res);
        preOrderIteration(root, res);
        return res;
    }

    //递归
    private void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

    //迭代
    private void preOrderIteration(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode tmp = deque.pop();
            res.add(tmp.val);
            if (tmp.right != null) {
                deque.push(tmp.right);
            }
            if (tmp.left != null) {
                deque.push(tmp.left);
            }
        }
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
