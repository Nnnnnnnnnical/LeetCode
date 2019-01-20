package leetcode.搜索.BackTracking回溯;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

 candidates 中的数字可以无限制重复被选取。
 */
public class leetcode39 {
    
    public static void main(String[] args){
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        List<List<Integer>> ans = combinationSum(candidates,target);
        for(int i = 0;i<ans.size();i++){
            for(int j = 0;j<ans.get(i).size();j++){
                System.out.print(ans.get(i).get(j)+",");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backTracking(ans,temp,target,0,candidates);
        return ans;
    }

    public static void backTracking(List<List<Integer>> ans,List<Integer> temp, int target,int start,int[] candidates){
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start;i<candidates.length&&target>0;i++){
            temp.add(candidates[i]);
            backTracking(ans,temp,target-candidates[i],i,candidates);
            temp.remove(temp.size()-1);
        }
    }
}
