package leetcode.搜索.BackTracking回溯;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class leetcode257 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        root.left = left;

    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        List<Integer> values = new ArrayList<>();
        backtracking(root, values, paths);
        return paths;
    }

    private static void backtracking(TreeNode node, List<Integer> values, List<String> paths) {
        if (node == null) {
            return;
        }
        values.add(node.val);
        if (isLeaf(node)) {
            paths.add(buildPath(values));
        } else {
            backtracking(node.left, values, paths);
            backtracking(node.right, values, paths);
        }
        values.remove(values.size() - 1);
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private static String buildPath(List<Integer> values) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            str.append(values.get(i));
            if (i != values.size() - 1) {
                str.append("->");
            }
        }
        return str.toString();
    }
}
