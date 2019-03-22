package leetcode.树;


/**
 * 给定一个二叉树，原地将它展开为链表。
 */
public class leetcode114 {


    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while(cur!=null){
            if(cur.left!=null){
                TreeNode p = cur.left;
                while (p.right!=null){
                    p = p.right;
                }
                p.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }

}
