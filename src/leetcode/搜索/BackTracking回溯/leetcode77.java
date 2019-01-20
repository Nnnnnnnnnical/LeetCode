package leetcode.搜索.BackTracking回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class leetcode77 {


    public static void main(String[] args){
        List<List<Integer>> ans = combine(4,2);
        for(int i = 0;i<ans.size();i++){
            for(int j = 0;j<ans.get(i).size();j++){
                System.out.print(ans.get(i).get(j)+",");
            }
            System.out.println();
        }
    }

    /**
     * 定义一个start来作为起始数字
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtracking(ans,temp,1,n,k);
        return ans;
    }

    public static void backtracking(List<List<Integer>> ans,List<Integer> temp,int start,int n,int k){
        if(temp.size() == k){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start;i<=n;i++){
            temp.add(i);
            backtracking(ans,temp,i+1,n,k);
            temp.remove(temp.size()-1);
        }

    }
}
