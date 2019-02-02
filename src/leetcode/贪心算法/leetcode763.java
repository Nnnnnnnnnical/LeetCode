package leetcode.贪心算法;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 */
public class leetcode763 {
    public static void main(String[] args){
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }

    private static int char2Index(char c) {
        return c - 'a';
    }

    /**
     * 存储每个字母最后一次出现的位置，遍历整个字符串，记录当前最后值lastIndex，如果出现遍历到某个位置等于改最后值lastIndex，那么截断字符串，此长度为切断点，以此类推至遍历完整个字符串
     * @param S
     * @return
     */
    public static List<Integer> partitionLabels(String S){
        int[] lastIndexArray = new int[26];
        for(int i =0;i<S.length();i++){
            lastIndexArray[char2Index(S.charAt(i))] = i;
        }
        List<Integer> answer = new ArrayList<>();
        int lastIndex = 0,firstIndex = 0;
        while (firstIndex<S.length()){

            for (int i = firstIndex;i<=lastIndex;i++){
                int index = lastIndexArray[char2Index(S.charAt(i))];
                if(index>lastIndex){
                    lastIndex = index;
                }
            }
            answer.add(lastIndex-firstIndex+1);
            firstIndex = lastIndex+1;
            lastIndex = firstIndex;
        }

        return answer;
    }
}
