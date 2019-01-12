package leetcode.二分查找;

public class leetcode69 {

    /**
     * 实现 int sqrt(int x) 函数。

     计算并返回 x 的平方根，其中 x 是非负整数。

     由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     * @param args
     */
    public static void main(String[] args){
        int x = 6;
        System.out.println(mySqrt(x));
    }

    /**
     * 二分查找，题目要求向下取整，则返回r，若向上取整，则返回l。
     * @param x
     * @return
     */
    public static int mySqrt(int x) {

        int l = 1,r = x;
        while(l<=r){
            int mid = l+(r-l)/2;
            int sqrt = x/mid;
            if(sqrt == mid){
                return mid;
            }else if(sqrt>mid){
                l = mid +1;
            }else {
                r = mid -1;
            }
        }
        return r;
    }

}
