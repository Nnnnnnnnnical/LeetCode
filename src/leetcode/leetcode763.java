package leetcode;

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

    public static List<Integer> partitionLabels(String S){
        int[] lastIndexArray = new int[26];
        for(int i =0;i<S.length();i++){
            lastIndexArray[char2Index(S.charAt(i))] = i;
        }
        List<Integer> answer = new ArrayList<>();
        int lastindex = 0,firstIndex = 0;
        while (firstIndex<S.length()){

            for (int i = firstIndex;i<=lastindex;i++){
                int index = lastIndexArray[char2Index(S.charAt(i))];
                if(index>lastindex){
                    lastindex = index;
                }
            }
            answer.add(lastindex-firstIndex+1);
            firstIndex = lastindex+1;
            lastindex = firstIndex;
        }

        return answer;
    }
}
