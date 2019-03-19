import java.util.LinkedList;
import java.util.Queue;


class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return java.lang.Math.max(leftDepth,rightDepth) + 1;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


