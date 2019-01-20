package leetcode.搜索.BackTracking回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class leetcode47 {


    public static void main(String[] args){
        int[] nums = new int[]{1,1,3};
        List<List<Integer>> ans = permute(nums);
        for(int i = 0;i<ans.size();i++){
            for(int j = 0;j<ans.get(i).size();j++){
                System.out.print(ans.get(i).get(j)+",");
            }
            System.out.println();
        }
    }

    /**
     * 数组元素可能含有相同的元素，进行排列时就有可能出现重复的排列，要求重复的排列只返回一个。

     在实现上，和 Permutations 不同的是要先排序，然后在添加一个元素时，判断这个元素是否等于前一个元素，如果等于，并且前一个元素   还未访问，那么就跳过这个元素。
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutes = new ArrayList<>();
        List<Integer> permuteList = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backTracking(permuteList,permutes,visited,nums);
        return permutes;
    }

    public static void backTracking(List<Integer> permuteList, List<List<Integer>> permutes, boolean[] visited , int[] nums){

        if(permuteList.size() == nums.length){
            permutes.add(new ArrayList<>(permuteList));
            return;
        }

        for(int i = 0;i<visited.length;i++){
            if (i!=0 && nums[i-1] == nums[i] && !visited[i-1]){
                continue;
            }

            if(visited[i]){
                continue;
            }

            visited[i] = true;
            permuteList.add(nums[i]);
            backTracking(permuteList,permutes,visited,nums);
            permuteList.remove(permuteList.size()-1);
            visited[i] = false;
        }

    }

}
