import java.util.*;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
//        inOrder(root, res);
        inOrderIteration(root, res);
        return res;
    }

    //递归
    private void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }

    //迭代
    private void inOrderIteration(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode cur = root;
        while (!deque.isEmpty() || cur != null) {
            while (cur != null) {
                deque.push(cur);
                cur = cur.left;
            }
            TreeNode tmp = deque.pop();
            res.add(tmp.val);
            if (tmp.right != null) {
                cur = tmp.right;
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
