package leetcode.动态规划;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 */
public class leetcode64 {
    
    public static void main(String[] args){
        int[][] gird = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(gird));
    }


    public static int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        //选取到本点的最小值（从上方和左方来的最小值）
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(i > 0 && j > 0)//分三种情况，第二行第二列之后
                    grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
                else if(i == 0 && j > 0)//第一行
                    grid[i][j] += grid[i][j-1];
                else if(i > 0 && j==0)//第一列
                    grid[i][j] += grid[i-1][j];
            }
        }

        //返回最后一个值
        return grid[grid.length-1][grid[0].length-1];

    }
}

