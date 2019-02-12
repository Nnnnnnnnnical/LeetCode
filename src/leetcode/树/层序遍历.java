package leetcode.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 层序遍历 {

    public List<Integer> levelTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> treeNode = new LinkedList<>();
        treeNode.add(root);
        while (!treeNode.isEmpty()){
            TreeNode node = treeNode.poll();
            ans.add(node.val);
            treeNode.add(node.left);
            treeNode.add(node.right);
        }
        return ans;
    }

}
