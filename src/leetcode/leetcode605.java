package leetcode;

public class leetcode605 {

    public static void main(String[] args){
        int[] flowerbed = {1,0,0,0,1};
        System.out.println(canPlaceFlowers(flowerbed,2));
    }

    /**
     * 创建指针pre，next分别指向当前位置i的前一个和后一个，判断他们都是0时，才能让count+1，最后比较n是否小于等于count，是则返回true
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
