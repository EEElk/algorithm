package class07;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/">...</a>
 */
public class Code01_BinaryTreeLevelOrderTraversalII {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        // 暂存每一层的节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 内层List
            List<Integer> curAns = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                curAns.add(curNode.val);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            ans.add(0, curAns);
        }
        return ans;
    }
}
