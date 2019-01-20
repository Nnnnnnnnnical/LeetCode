package leetcode.搜索.BackTracking回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

 candidates 中的每个数字在每个组合中只能使用一次。
 */
public class leetcode40 {

    public static void main(String[] args){
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 7;
        List<List<Integer>> ans = combinationSum2(candidates,target);
        for(int i = 0;i<ans.size();i++){
            for(int j = 0;j<ans.get(i).size();j++){
                System.out.print(ans.get(i).get(j)+",");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        backTracking(ans,temp,target,0,candidates,visited);
        return ans;
    }

    /**
     * 然后在添加一个元素时，判断这个元素是否等于前一个元素，如果等于，并且前一个元素   还未访问，那么就跳过这个元素。
     * @param ans
     * @param temp
     * @param target
     * @param start
     * @param candidates
     * @param visited
     */
    public static void backTracking(List<List<Integer>> ans,List<Integer> temp, int target,int start,int[] candidates,boolean[] visited){
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start;i<candidates.length&&target>0;i++){

            if (i != 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) {
                continue;
            }

            temp.add(candidates[i]);
            visited[i] = true;
            backTracking(ans, temp, target - candidates[i], i+1, candidates, visited);
            visited[i] = false;
            temp.remove(temp.size() - 1);


        }
    }
}
