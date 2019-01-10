package leetcode.贪心算法;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class leetcode53 {

    public static void main(String[] args){
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {

        int pre = nums[0];
        int max = pre;
        for(int i = 1;i<nums.length;i++){
            if(pre>0){
                pre = pre+nums[i];
            }else {
                pre = nums[i];
            }
            max = Math.max(max,pre);
        }
        return max;
    }
}
