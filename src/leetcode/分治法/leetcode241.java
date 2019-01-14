package leetcode.分治法;

import java.util.ArrayList;
import java.util.List;

/**
 *给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 */
public class leetcode241 {

    public static void main(String[] args){
        String input = "2-1-3";
        for(int i =0;i<diffWaysToCompute(input).size();i++){
            System.out.print(diffWaysToCompute(input).get(i)+",");
        }
    }

    /**
     * 遍历数组，每次遍历到运算符，则用分治思想。
     * @param input
     * @return
     */
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));

                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                ans.add(l + r);
                                break;
                            case '-':
                                ans.add(l - r);
                                break;
                            case '*':
                                ans.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (ans.size() == 0) {
            ans.add(Integer.valueOf(input));
        }
        return ans;
    }
}
