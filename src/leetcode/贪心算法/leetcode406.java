package leetcode.贪心算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode406 {

    public static void main(String[] args){

        int[][] ints = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        reconstructQueue(ints);

        for(int i = 0 ;i<ints.length;i++){
            for(int j = 0;j<2;j++){
                System.out.println(ints[i][j]);
            }
        }
    }

//    public static int[][] reconstructQueue(int[][] people) {
//        if(people.length == 0){
//            return null;
//        }
//
//        Arrays.sort(people, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[0] == o2[0]){
//                    return o1[1]-o2[1];
//                }
//                return o2[0]-o1[0];
//            }
//        });
//        List<int[]> list = new ArrayList<>();
//
//        for(int[] p : people){
//            list.add(p);
//        }
//        return list.toArray(new int[list.size()][]);
//    }
    public static int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }
        return queue.toArray(new int[queue.size()][]);
    }
}
