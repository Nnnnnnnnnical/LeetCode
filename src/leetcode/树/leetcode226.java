package leetcode.树;

/**
 * 翻转一棵二叉树。
 */
public class leetcode226 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode left = root.left;// 后面的操作会改变 left 指针，因此先保存下来
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }
}
