package leetcode.动态规划;

/**
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 */
public class leetcode413 {
    public static void main(String[] args){

        int[] A = new int[]{1, 3, 5, 7, 9};
        System.out.println(numberOfArithmeticSlices(A));
    }

    /**
     * 由题意知若为等差数列，那么能拆分成dp[i] = dp[i - 1] + 1个等差数列
     * @param A
     * @return
     */
    public static int numberOfArithmeticSlices(int[] A) {

        if(A==null||A.length==0){
            return 0;
        }

        int[] dp = new int[A.length];
        int n = A.length;
        for(int i = 2;i<n;i++){
            if(A[i]-A[i-1] == A[i-1]-A[i-2]){
                dp[i] = dp[i-1] + 1;
            }
        }

        int count = 0;
        for(int ans:dp){
            count = ans+count;
        }
        return count;

    }
}
