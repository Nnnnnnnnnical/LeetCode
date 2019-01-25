package leetcode.动态规划.最长递增子序列;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 */
public class leetcode300 {


    public static void main(String[] args){
        int[] nums = new int[]{10,9,2,5,4,7,3,18};
        System.out.println(lengthOfLIS(nums));
    }

    /**
     * 创建tail数组，遍历原数组，每次将遍历的值用二分查找找出他的索引，取代原来索引的值，当该索引为length时，增加length。
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {

        int[] tail = new int[nums.length];
        int length = 0;
        for(int num : nums){
            int index = binarySearch(tail,length,num);
            tail[index] = num;
            if(index == length){
                length++;
            }
        }
        return length;
    }

    private static int binarySearch(int[] tails, int len, int key) {

        int l = 0,r = len;
        while(l < r){
            int mid = l+(r-l)/2;
            if(tails[mid] < key){
                l = mid+1;
            }else {
                r = mid;
            }
        }
        return l;
    }
}
