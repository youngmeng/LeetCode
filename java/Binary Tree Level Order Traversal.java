/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *    3
 *   / \
 *  9  20
 *  /   \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
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
 
//---递归---

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (root == null)
            return lists;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            Queue<TreeNode> queueHelper = new LinkedList<TreeNode>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null)
                    queueHelper.add(node.left);
                if (node.right != null)
                    queueHelper.add(node.right);
            }
            lists.add(list);
            queue = queueHelper;
        }

        return lists;
    }
}

//---迭代---

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        traverse(root, 1, lists);

        return lists;
    }

    public void traverse(TreeNode root, int level, List<List<Integer>> lists) {
        if (root == null)
            return;

        if (level > lists.size())
            lists.add(new ArrayList<Integer>());

        lists.get(level - 1).add(root.val);
        traverse(root.left, level + 1, lists);
        traverse(root.right, level + 1, lists);
    }
}
