package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素
 */

public class leetcode347 {
    public static void main(String[] args){
        int[] nums = new int[]{1,1,2,2,2,3,3,4,5,7,6};
        System.out.println(topKFrequent(nums,2));
    }

    public static List<Integer> topKFrequent(int[] nums,int k){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length+1];
        for(int key :map.keySet()){
            int frequency = map.get(key);
            if(buckets[frequency] == null){
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);

        }

        List<Integer> topK = new ArrayList<>();
        for(int i = buckets.length-1;i>=0&&topK.size()<k;i--){
            if(buckets[i]!=null){
                topK.addAll(buckets[i]);
            }
        }
        return topK;
    }


//    public static List<Integer> topKFrequent(int[] nums, int k) {
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int i : nums){
//                map.put(i,map.getOrDefault(i,0)+1);
//        }
//
//        List<Integer>[] buckets = new ArrayList[nums.length + 1];
//        for (int key : map.keySet()) {
//            int frequency = map.get(key);
//            System.out.println(frequency);
//            if (buckets[frequency] == null) {
//                buckets[frequency] = new ArrayList<>();
//            }
//            buckets[frequency].add(key);
//
//        }
//        List<Integer> topK = new ArrayList<>();
//        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
//            if (buckets[i] != null) {
//                topK.addAll(buckets[i]);
//            }
//        }
//        return topK;
//    }
}
