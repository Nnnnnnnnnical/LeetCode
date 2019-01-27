package leetcode.树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 */
public class leetcode543 {

    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = TreeNode.stringToTreeNode(line);
            System.out.println(diameterOfBinaryTree(root));
        }

    }

    /**
     * 在leetcode上贴代码时要去掉static
     */
    private static int max = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    public static int depth(TreeNode root){
        if(root ==null){
            return 0;
        }

        int l = depth(root.left);
        int r = depth(root.right);
        max = Math.max(max, l + r);
        return Math.max(l, r) + 1;


    }
}
