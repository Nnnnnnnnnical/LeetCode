package leetcode.排序;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 荷兰国旗
 */
public class leetcode75 {

    public static void main(String[] args){
        int[] nums = new int[]{1,0,2,2,0,1};
        sortColors(nums);
        for(int i = 0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }

    /**
     * 三向切分快速排序
     * @param nums
     */
    public static void sortColors(int[] nums){
       int left = 0,mid = 0,right = nums.length;
       while(mid<right){
           if(nums[mid] == 0){
               swap(nums,left++,mid++);
           }else if(nums[mid] == 2){
               swap(nums,--right,mid);
           }else {
               mid++;
           }
       }
    }


    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
