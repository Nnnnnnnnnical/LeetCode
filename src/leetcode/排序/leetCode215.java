package leetcode.排序;

import java.util.PriorityQueue;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */

public class leetCode215 {

    public static void main(String[] args){
        int[] nums = new int[]{1,1,2,3,4,5,7,6};
        System.out.println(findKthLargest(nums,2));
    }

    /**
     * 优先队列
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i : nums){
            priorityQueue.add(i);
            if(priorityQueue.size()>k){
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }

}
