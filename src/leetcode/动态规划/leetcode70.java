package leetcode.动态规划;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class leetcode70 {
    public static void main(String[] args){
        int n = 4;
        System.out.println(climbStairs(n));

    }

    /**
     * 递归解法
     * @param n
     * @return
     */
//    public static int climbStairs(int n) {
//        if(n <=3){
//            return n;
//        }
//        n = climbStairs(n-1)+climbStairs(n-2);
//        return n;
//    }

    /**
     *解法2 满足斐波那契
     */
    public static int climbStairs(int n) {
        if(n<=3){
            return n;
        }
        int[] a = new int[n];
        a[0] = 1;
        a[1] = 2;
        for(int i = 2;i<n;i++){
            a[i] = a[i-1] + a[i-2];
        }
        return a[n-1];
    }
}
