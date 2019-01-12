package leetcode.二分查找;

/**
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 */
public class leetcode540 {

    public static void main(String[] args){
        int[] nums = new int[]{1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(nums));;
    }

    /**
     * 根据题意可以知道当mid为偶数，且当前值等于下一个值时，前面所有的数都是两个一起出现的，那么l=mid+2，取后半部分，否则，取后半部分；如果mid为奇数，那么让mid往前移一位变成偶数，又满足上面的条件。
     * @param nums
     * @return
     */
    public static int singleNonDuplicate(int[] nums) {

        int l = 0,r = nums.length-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(mid%2==1){
                mid = mid-1;
            }

            if(nums[mid] == nums[mid+1]){
                l = mid+2;

            }else {
                r = mid;
            }
        }
        return nums[l];
    }


}
