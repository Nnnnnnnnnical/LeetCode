package leetcode.二分查找;

/**
 * 题目描述：给定一个元素 n 代表有 [1, 2, ..., n] 版本，可以调用 isBadVersion(int x) 知道某个版本是否错误，要求找到第一个错误的版本。

 如果第 m 个版本出错，则表示第一个错误的版本在 [l, m] 之间，令 h = m；否则第一个错误的版本在 [m + 1, h] 之间，令 l = m + 1。

 因为 h 的赋值表达式为 h = m，因此循环条件为 l < h。
 无测试类
 */
public class leetcode278 {


    /**
     * 无测试类
     * 简单的二分查找
     * @param n
     * @return
     */
//    public int firstBadVersion(int n) {
//        int l = 1,r = n;
//        while(l<n){
//            int mid = l+(r-l)/2;
//            if(isBadVersion(mid)){
//                r = mid;
//            }else {
//                l = mid;
//            }
//        }
//        return l;
//    }
}
