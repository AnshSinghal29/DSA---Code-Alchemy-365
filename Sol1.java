// leetcode problem no. 235 
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// 2. Renamed to Sol1 to match your filename Sol1.java
public class Sol1 {
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
        // You can add test cases here if you want to see it in action
    }
}