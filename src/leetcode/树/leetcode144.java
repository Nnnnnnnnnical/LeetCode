package leetcode.树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 */
public class leetcode144 {

    /**
     * 用栈来存储树，先进后出。
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node == null) continue;
            ans.add(node.val);
            stack.push(node.right);// 先右后左，保证左子树先遍历
            stack.push(node.left);
        }
        return ans;

    }
}
