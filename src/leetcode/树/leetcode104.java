package leetcode.树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class leetcode104 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = TreeNode.stringToTreeNode(line);
            System.out.println(maxDepth(root));

        }

    }

    public static int maxDepth(TreeNode root) {
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
