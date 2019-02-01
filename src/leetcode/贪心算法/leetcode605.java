package leetcode.贪心算法;

public class leetcode605 {

    /**
     * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。

     给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
     * @param args
     */
    public static void main(String[] args){
        int[] flowerbed = {1,0,0,0,1};
        System.out.println(canPlaceFlowers(flowerbed,2));
    }

    /**
     * 遍历flower，如果当前位置不为1，则创建指针pre，next分别指向当前位置i的前一个和后一个，判断他们都是0时，才能让count+1，最后比较n是否小于等于count，是则返回true
     * @param flowerbed
     * @param n
     * @return
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        int count = 0;
        for(int i = 0 ;i<flowerbed.length;i++){
            if(flowerbed[i]==1){
                continue;
            }

            int pre,next;
            if(i == 0){
                pre = 0;
            }else {
                pre = flowerbed[i-1];
            }
            if(i == flowerbed.length-1){
                next = 0;
            }else {
                next = flowerbed[i+1];
            }


            if(pre==0&&next==0){
                count++;
                flowerbed[i] = 1;
            }

        }
        if(n <= count){
            return true;
        }
        return false;
    }
}
