package leetcode.搜索.BackTracking回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
 */
public class leetcode17 {

    public static void main(String[] args){
        String digits = "96";
        List<String> ans = letterCombinations(digits);
        for(int i = 0;i<ans.size();i++){
            System.out.print(ans.get(i)+ "  ");
        }
    }

    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * 变量digits中的数组，对应KEYS中的字母，依次组合。
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {

        List<String> combinations = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return combinations;
        }
        doCombination(new StringBuilder(),combinations,digits);
        return combinations;
    }

    private static void doCombination(StringBuilder prefix, List<String> combinations, final String digits) {
        if(prefix.length() == digits.length()){
            combinations.add(prefix.toString());
            return;
        }

        int curDigits = digits.charAt(prefix.length())-'0';
        String letter = KEYS[curDigits];
        for(char c : letter.toCharArray()){
            prefix.append(c);
            doCombination(prefix,combinations,digits);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
}
