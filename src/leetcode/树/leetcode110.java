package leetcode.树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  给定一个二叉树，判断它是否是高度平衡的二叉树。
 */
public class leetcode110 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = TreeNode.stringToTreeNode(line);
            System.out.println(isBalanced(root));

        }

    }


    private static boolean result = true;

    public static boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    public static int maxDepth(TreeNode root){
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
