package leetcode.搜索;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 */
public class leetcode200 {

    public static void main(String[] args){
        char[][] grid = new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(numIslands(grid));
    }

    public static int m ,n;
    public static int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};//用来定位坐标的上下左右

    /**
     * 遍历岛屿数组，如果是1,进行广度优先遍历，并将原来的1改成0，标记为已经遍历，再遍历该点上下左右的点是否满足。
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid){

        if(grid == null || grid.length == 0){
            return 0;
        }

        m = grid.length;
        n = grid[0].length;
        int numsIsland = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    numsIsland++;
                }
            }
        }
        return numsIsland;
    }

    /**
     * 广度优先遍历
     * @param grid
     * @param i
     * @param j
     */
    public static void dfs(char[][] grid,int i ,int j){
        if(i<0||i>=m||j<0||j>=n||grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';
        for(int[] d :direction){
            dfs(grid,d[0]+i,d[1]+j);
        }

    }

}
