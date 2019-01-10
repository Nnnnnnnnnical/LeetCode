package leetcode;

import java.util.Arrays;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 */
public class leetcode455 {

    public static void main(String[] args){
        int[] g = new int[]{3,4,7};
        int[] s = new int[]{2,3,8};
        System.out.println(findContentChildren(g,s));
    }

    /**
     * 现将两个数组排序，以孩子的胃口为基准，g0为3去s中寻找大于等于3的值，以此类推，一直到g遍历完或者s遍历完
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0,j = 0 ,i = 0;
        while(i<g.length&&j<s.length){
            if(g[i]<=s[j]){
                count++;
                i++;
            }
            j++;
        }
        return count;
    }
}
