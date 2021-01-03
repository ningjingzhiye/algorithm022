import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                               int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int pivot = preorder[preLeft];
        TreeNode root = new TreeNode(pivot);
        int pivotIndex = indexMap.get(pivot);
        root.left = buildTree(preorder, preLeft + 1, preLeft + pivotIndex - inLeft,
                inorder, inLeft, pivotIndex - 1);
        root.right = buildTree(preorder, preLeft + pivotIndex - inLeft + 1, preRight,
                inorder, pivotIndex + 1, inRight);
        return root;
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
