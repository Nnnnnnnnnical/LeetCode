package leetcode.搜索;

/**
 *给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。

 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 */
public class leetcode695 {

    public static void main(String[] args){
        int[][] grid = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0}, {0,0,0,0,0,0,0,1,1,1,0,0,0}, {0,1,1,0,1,0,0,0,0,0,0,0,0}, {0,1,0,0,1,1,0,0,1,0,1,0,0}, {0,1,0,0,1,1,0,0,1,1,1,0,0}, {0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0}, {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(maxAreaOfIsland(grid));
    }

    private static int l = 0,w = 0;
    private static int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};//用来定位坐标的上下左右


    /**
     * 类比200题，一个计数是在进入dfs前，求的是进入dfs前的grid[i][j]的个数，此题是在进入dfs后开始计数，每次调用一次dfs计数一次，求得是grid[i][j]的大小。
     * @param grid
     * @return
     */
    public static int maxAreaOfIsland(int[][] grid) {
        
        if(grid.length == 0||grid==null){
            return 0;
        }
        l = grid.length;
        w = grid[0].length;
        int maxArea = 0;
        for(int i = 0;i<l;i++){
            for(int j = 0;j<w;j++){
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }

    public static int dfs(int[][] grid,int i ,int j){

        if(i<0||i>=l||j<0||j>=w||grid[i][j]==0){
            return 0;
        }

        grid[i][j]=0;
        int area = 1;
        for(int[] d :direction){
            area += dfs(grid,d[0]+i,d[1]+j);
        }
        return area;
    }

}
