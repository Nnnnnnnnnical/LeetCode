package leetcode.搜索.BackTracking回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

 说明：

 所有数字都是正整数。
 解集不能包含重复的组合。
 */
public class leetcode216 {

    public static void main(String[] args){
        List<List<Integer>> ans = combinationSum3(3,15);
        for(int i = 0;i<ans.size();i++){
            for(int j = 0;j<ans.get(i).size();j++){
                System.out.print(ans.get(i).get(j)+",");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backTracking(ans,temp,k,n,1);
        return ans;
    }

    public static void backTracking(List<List<Integer>> ans,List<Integer> temp,int k,int n,int start){
        if(k == 0 && n == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        if(k == 0 || n == 0){
            return;
        }

        for(int i = start;i<=9;i++){
            temp.add(i);
            backTracking(ans,temp,k-1,n-i,i+1);
            temp.remove(temp.size()-1);
        }

    }
}
