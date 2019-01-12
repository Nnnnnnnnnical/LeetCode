package leetcode.二分查找;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

 你的算法时间复杂度必须是 O(log n) 级别。

 如果数组中不存在目标值，返回 [-1, -1]。
 */
public class leetcode43 {

    public static void main(String[] args){
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        int[] ans = searchRange(nums,target);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }

    /**
     * 分别区起始位置和终止位置，如果起始位置等于长度+1或者nums[first]！=target，则说明不存在该数，否则返回first和last。
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int first = binarySearch(nums,target);
        int last = binarySearch(nums,target+1)-1;
        if(first == nums.length || nums[first]!=target){
            return new int[]{-1,-1};
        }else {
            return new int[]{first,last};
        }
    }

    /**
     * 二分查找，可参考744 69题，取大于等于target，返回l
     * @param nums
     * @param target
     * @return
     */
    private static int binarySearch(int[] nums, int target) {
        int l = 0,r = nums.length;
        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid]<target){
                l = mid+1;
            }else {
                r = mid;
            }
        }
        return l;
    }
}
