/**
 * [236] Lowest Common Ancestor of a Binary Tree
 * -----------------------------------------------------------------------------
 * INTUITION:
 * Unlike a BST, we cannot use values to decide where to go. We must search 
 * both the left and right subtrees. The LCA is the node where one target (p) 
 * is found in the left subtree and the other target (q) is found in the right 
 * subtree (or vice-versa).
 *
 * APPROACH (Recursive DFS):
 * 1. Base Case: If the current node is null, or if it matches p or q, return the 
 * current node.
 * 2. Recursive Step: Search the left and right subtrees for p or q.
 * 3. Result Synthesis:
 * - If both left and right calls return a non-null value, the current node 
 * is the LCA.
 * - If only one side returns a non-null value, it means both p and q are 
 * located on that side (or only one was found so far). Return the non-null result.
 * - If both are null, return null.
 *
 * COMPLEXITY:
 * - Time Complexity: O(N), where N is the number of nodes in the tree. In the 
 * worst case, we might have to visit every node.
 * - Space Complexity: O(H), where H is the height of the tree. This is due 
 * to the recursion stack (O(N) in a skewed tree, O(log N) in a balanced tree).
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

class LCABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base Case: If we reach a leaf (null) or find p or q
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search for p and q in the left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If p is found in one subtree and q in the other, current root is the LCA
        if (left != null && right != null) {
            return root;
        }

        // If only one subtree contains p or q, return that result
        // If neither subtree contains them, this will return null
        return (left != null) ? left : right;
    }

    public static void main(String[] args) {
        System.out.println("Code compiled and executed successfully!");

    }
}