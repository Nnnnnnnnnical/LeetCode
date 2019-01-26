package leetcode.树;

/**
 *  给定一个二叉树，判断它是否是高度平衡的二叉树。
 */
public class leetcode110 {

    private boolean result = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if(Math.abs(l-r)>1){
            result = false;
        }
        return 1+Math.max(l,r);
    }

}
