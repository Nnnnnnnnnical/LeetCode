package leetcode.二分查找;

/**
 * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。

 数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
 */
public class leetcode744 {


    public static void main(String[] args){
        char[] letters = {'c','f','j'};
        char target = 'c';
        System.out.println(nextGreatestLetter(letters,target));
    }

    /**
     * 类似于69题，向上取（取大于mid）返回l，否则取r；这里需要注意的是能够旋转，所以当l=n的时候，应该返回第一个数letters[0]
     * @param letters
     * @param target
     * @return
     */
    public static char nextGreatestLetter(char[] letters, char target) {

        int n = letters.length;
        int l = 0, h = n - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (letters[m] <= target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l < n ? letters[l] : letters[0];

    }

    //解法2
//    public static char nextGreatestLetter(char[] letters, char target) {
//
//        int l = 0,r = letters.length-1;
//        while(l<r){
//            int mid = l+(r-l)/2;
//            if(target >= letters[mid]){
//                l = mid +1;
//            }else {
//                r = mid;
//            }
//        }
//        if(target>=letters[letters.length-1]){
//            return letters[0];
//        }
//
//        return letters[l];
//
//    }

}
