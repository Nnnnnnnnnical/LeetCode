package leetcode.搜索.BackTracking回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

 说明：解集不能包含重复的子集。
 */
public class leetcode78 {

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3};

        List<List<Integer>> ans = subsets(nums);
        for(int i = 0;i<ans.size();i++){
            for(int j = 0;j<ans.get(i).size();j++){
                System.out.print(ans.get(i).get(j)+",");
            }
            System.out.println();
        }

    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i = 0;i<=nums.length;i++){
            backTracking(ans,temp,i,nums,0);
        }

        return ans;
    }

    public static void backTracking(List<List<Integer>> ans,List<Integer> temp,int size,int[] nums,int start){

        if(temp.size() == size){
            ans.add(new ArrayList<>(temp));
        }

        for(int i = start;i<nums.length;i++){
            temp.add(nums[i]);
            backTracking(ans, temp, size, nums, i+1);
            temp.remove(temp.size()-1);

        }
    }
}
