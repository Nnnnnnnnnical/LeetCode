package leetcode.二分查找;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

 ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

 请找出其中最小的元素。

 你可以假设数组中不存在重复元素。
 */
public class leetcode153 {

    public static void main(String[] args){
        int[] nums = new int[]{4,5,6,2,3};
        System.out.println(findMin(nums));
    }

    /**
     * 因为是旋转数组，所以用mid与最后一个数字相比，如果mid大，那么说明发生了旋转，最小值在后半区，否则最小值在前半区
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {
        int l = 0,r = nums.length-1;

        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid]>nums[r]){
                l =mid +1;
            }else {
                r = mid;
            }
        }
        return nums[l];
    }
}
