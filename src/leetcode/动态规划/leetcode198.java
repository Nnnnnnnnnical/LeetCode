package leetcode.动态规划;

import java.util.Map;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 */
public class leetcode198 {
    public static void main(String[] args){
        int[] nums = new int[]{2,7,9,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if(nums == null||nums.length == 0){
            return 0;
        }
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        //return Math.max(rob(nums,0,n),rob(nums,1,n));//
        return rob(nums,0,n);
    }

    private static int rob(int[] nums, int first, int last) {
        int pre2 = 0,pre1 = 0;
        for(int i = first;i<last;i++){
            int current = Math.max(pre1,pre2+nums[i]);
            pre2 = pre1;
            pre1 = current;
        }
        return pre1;
    }
}
