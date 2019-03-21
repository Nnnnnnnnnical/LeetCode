package leetcode.贪心算法;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

 注意你不能在买入股票前卖出股票。
 对比122题
 */
public class leetcode121 {

    public static void main(String[] args){
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    /**
     * 遍历数组，获取当前最小值，用当前值-最小值为当前最大值。
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {

        if(prices.length == 0){
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for(int i = 1;i<prices.length;i++){

            if(prices[i]<min){
                min = prices[i];
            }
            if(max <prices[i]-min){
                max = prices[i]-min;
            }
        }
        return max;
    }
}
