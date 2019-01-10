package leetcode.贪心算法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 */
public class leetCode451 {
    public static void main(String[] args){
        System.out.println(frequencySort("tree"));
    }

    /**
     * 类似于347题。
     * @param s
     * @return
     */
    public static String frequencySort(String s){
        Map<Character,Integer> map = new HashMap<>();
        for(char c :s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        List<Character>[] buckets = new List[map.size()];
        for(char c :map.keySet()){
            int frequency = map.get(c);
            if(buckets[frequency] == null){
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(c);
        }

        StringBuffer stringBuffer = new StringBuffer();
        for(int i = buckets.length-1;i>=0;i--){
            if(buckets[i]==null){
                continue;
            }
            for(char c :buckets[i]){
                for(int j = 0;j<i;j++){
                    stringBuffer.append(c);
                }
            }
        }
        return stringBuffer.toString();
    }

//    public static String frequencySort(String s) {
//
//        Map<Character,Integer> map = new HashMap<>();
//        for(char i : s.toCharArray()){
//            map.put(i,map.getOrDefault(i,0)+1);
//        }
//
//        List<Character>[] buckets = new ArrayList[s.length()+1];
//        for(char c:map.keySet()){
//            int frequency = map.get(c);
//            if(buckets[frequency] == null){
//                buckets[frequency] = new ArrayList<>();
//            }
//            buckets[frequency].add(c);
//        }
//
//        StringBuffer stringBuffer = new StringBuffer();
//        for(int i = buckets.length-1;i>=0;i--){
//            if (buckets[i] == null) {
//                continue;
//            }
//            System.out.println(buckets[i]);
//            for(char c :buckets[i]){
//                for(int j = 0;j<i ;j++){
//                    stringBuffer.append(c);
//                }
//            }
//
//        }
//
//        return stringBuffer.toString();
//    }
}
