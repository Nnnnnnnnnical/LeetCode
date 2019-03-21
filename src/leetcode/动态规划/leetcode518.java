package leetcode.动态规划;

public class leetcode518 {

    public static void main(String[] args){
        int[] coins = {1,5,2};
        int mount = 5;
        System.out.println(change(mount,coins));
    }

    public static int change(int amount, int[] coins) {
        if (amount == 0 || coins == null || coins.length == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
