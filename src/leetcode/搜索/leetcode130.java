package leetcode.搜索;

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 */
public class leetcode130 {

    public static void main(String[] args){
        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(board);
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int m, n;

    /**
     * 先填充最外侧，剩下的就是里侧了。
     * @param board
     */
    public static void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        m = board.length;
        n = board[0].length;

        for(int i =0;i<m;i++){
            dfs(board,i,0);
            dfs(board,i,n-1);
        }

        for(int i =0;i<n;i++){
            dfs(board,0,i);
            dfs(board,m-1,i);
        }

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }else if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

    }

    private static void dfs(char[][] board, int r, int c) {

        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'T';
        for(int[] d :direction){
            dfs(board,r+d[0],c+d[1]);
        }
    }
}
