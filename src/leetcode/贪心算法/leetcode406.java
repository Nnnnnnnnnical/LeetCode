package leetcode.贪心算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 */
public class leetcode406 {

    public static void main(String[] args){

        int[][] ints = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] ans = reconstructQueue(ints);

        for(int i = 0 ;i<ans.length;i++){
            for(int j = 0;j<2;j++){
                System.out.print(ans[i][j]+",");
            }
            System.out.println();
        }
    }

    /**
     * 我们把这个数组按身高降序排列，重复的部分按k升序排列
     * 假设有一个空队列
     我们先把身高最高的插入，并且它的第二位一定为0
     接下来我们把次高的元素插入合适的位置，这个元素无论放到队列中的哪个位置(最高元素的前面或者后面)，
     对原队列中元素的第二位没有任何影响(同时又能放入合适的位置)，
     因为原队列中的元素都比它高，所以不会改变原数组的第二位。
     以此进行，把次次高的元素插入合适位置，同时又不会对原队列产生影响。
     * @param people
     * @return
     */
    public static int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0 || people[0].length == 0){
            return new int[0][0];
        }

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1]-o2[1];
                }
                return o2[0]-o1[0];
            }
        });
        List<int[]> list = new ArrayList<>();

        for(int[] p : people){
            list.add(p[1],p);
        }
        return list.toArray(new int[list.size()][]);
    }

//    public static int[][] reconstructQueue(int[][] people) {
//        if (people == null || people.length == 0 || people[0].length == 0) {
//            return new int[0][0];
//        }
//        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
//        List<int[]> queue = new ArrayList<>();
//        for (int[] p : people) {
//            queue.add(p[1], p);
//        }
//        return queue.toArray(new int[queue.size()][]);
//    }
}
