package leetcode.动态规划;

/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 */
public class leetcode303 {

    public static void main(String[] args){
        int [] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);
        int param_1 = obj.sumRange(0,2);
        System.out.println(param_1);

    }

    static class NumArray {

        private int[] sums;

        //求出前n个数之和，存入sums中
        public NumArray(int[] nums) {
            sums = new int[nums.length+1];
            for(int i = 1;i<=nums.length;i++){
                sums[i] = sums[i-1]+nums[i-1];
            }
        }

        public int sumRange(int i, int j) {
            return sums[j+1] - sums[i];
        }
    }
}
