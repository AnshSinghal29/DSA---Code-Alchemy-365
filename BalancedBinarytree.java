/**
 * [110] Balanced Binary Tree
 * -----------------------------------------------------------------------------
 * INTUITION:
 * A binary tree is height-balanced if the depth of the two subtrees of every 
 * node never differs by more than 1. 
 * * A naive "Top-Down" approach would calculate the height of subtrees repeatedly, 
 * leading to O(n²) complexity. The "Bottom-Up" approach is better: we check the 
 * balance factor during the height calculation. If any subtree is unbalanced, 
 * we "bubble up" an error code (-1) to avoid further unnecessary calculations.
 *
 * APPROACH (Optimized Bottom-Up DFS):
 * 1. Create a helper function `checkHeight(node)` that returns the height of 
 * the node if it's balanced, or -1 if it's not.
 * 2. Base Case: A null node has a height of 0.
 * 3. Recursive Step:
 * - Recursively find the height of the left subtree. If it returns -1, 
 * the left side is unbalanced; return -1 immediately.
 * - Recursively find the height of the right subtree. If it returns -1, 
 * the right side is unbalanced; return -1 immediately.
 * 4. Balance Logic:
 * - If the absolute difference between `leftHeight` and `rightHeight` 
 * is > 1, the current node is unbalanced. Return -1.
 * - Otherwise, return the actual height: max(leftHeight, rightHeight) + 1.
 * 5. Final Result: If `checkHeight(root)` is not -1, the tree is balanced.
 *
 * COMPLEXITY:
 * - Time Complexity: O(n), where n is the number of nodes. Each node is 
 * visited exactly once.
 * - Space Complexity: O(h), where h is the height of the tree, representing 
 * the maximum depth of the recursion stack.
 * -----------------------------------------------------------------------------
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class BalancedBinarytree {
     public boolean isBalanced(TreeNode root) {
          // If the helper function returns -1, it's unbalanced
          return checkHeight(root) != -1;
     }

     private int checkHeight(TreeNode node) {
          if (node == null) {
               return 0;
          }

          // Check height of left subtree
          int leftHeight = checkHeight(node.left);

          if (leftHeight == -1)
               return -1;

          // Check height of right subtree
          int rightHeight = checkHeight(node.right);
          if (rightHeight == -1)
               return -1;

          // If the difference in height is more than 1, it's unbalanced
          if (Math.abs(leftHeight - rightHeight) > 1) {
               return -1;
          }

          // Return the actual height of the current node
          return Math.max(leftHeight, rightHeight) + 1;
     }
}