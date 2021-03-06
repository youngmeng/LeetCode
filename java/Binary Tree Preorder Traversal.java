/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * return [1,2,3].
 * <p>
 * Note: Recursive solution is trivial, could you do it iteratively?
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 
 /*
 1. ---递归---
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        if (root == null)
            return list;

        preorder(root, list);

        return list;
    }

    public void preorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        list.add(root.val);

        if (root.left != null)
            preorder(root.left, list);

        if (root.right != null)
            preorder(root.right, list);
    }
}

/*
 2. ---迭代---
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        if (root == null)
            return list;

        TreeNode cur = root.left;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        list.add(root.val);
        stack.push(root);

        while (!stack.empty()) {
            while (cur != null) {
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode node = stack.pop();
            cur = node.right;
            if (cur != null) {
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
        }

        return list;
    }
}
