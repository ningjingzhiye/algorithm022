import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<QueueNode> deque = new LinkedList<>();
        deque.offer(new QueueNode(root, 1));
        while (!deque.isEmpty()) {
            QueueNode queueNode = deque.poll();
            TreeNode node = queueNode.node;
            int depth = queueNode.depth;
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                deque.offer(new QueueNode(node.left, depth + 1));
            }
            if (node.right != null) {
                deque.offer(new QueueNode(node.right, depth + 1));
            }
        }
        return 0;
    }

    class QueueNode {
        TreeNode node;
        int depth;

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
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
