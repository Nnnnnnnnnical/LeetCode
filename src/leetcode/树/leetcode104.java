package leetcode.树;

public class leetcode104 {

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        /*
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if(Math.abs(l-r)>1){
            result = false;
        }
        return 1+Math.max(l,r);
         */
    }
}
