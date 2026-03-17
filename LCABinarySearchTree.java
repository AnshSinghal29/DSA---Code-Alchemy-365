
/**
 * [235] Lowest Common Ancestor of a Binary Search Tree
 * * -----------------------------------------------------------------------------
 * INTUITION:
 * The core property of a Binary Search Tree (BST) is that for any node, all 
 * left descendants are smaller and all right descendants are larger. 
 * The Lowest Common Ancestor (LCA) is the "split point" where p and q 
 * no longer belong to the same subtree.
 * 
 * * APPROACH:
 * 1. Start at the root.
 * 2. If both p and q are smaller than the current node, the LCA must be in the 
 * left subtree. Move the current pointer to root.left.
 * 3. If both p and q are larger than the current node, the LCA must be in the 
 * right subtree. Move the current pointer to root.right.
 * 4. If one is smaller and one is larger (or the current node matches p or q), 
 * you have found the LCA. Return the current node.
 * 
 * * COMPLEXITY:
 * - Time Complexity: O(h), where h is the height of the tree. We visit at most 
 * one node per level.
 * - Space Complexity: O(1) for the iterative approach as we don't use the 
 * recursion stack.
 * -----------------------------------------------------------------------------
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class LCABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println("Code compiled and executed successfully!");

    }
}