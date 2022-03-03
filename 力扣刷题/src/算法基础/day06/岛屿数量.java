package 算法基础.day06;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class 岛屿数量 {
    void dfs(char[][] grid,int r,int c){
        int nr=grid.length;//行数
        int nc = grid[0].length;//列数
        if(r<0 || c<0 || r>=nr|| c>=nc||grid[r][c]=='0'){
            return;
        }
//        将经过的点变成0
        grid[r][c]='0';
//        遍历上下左右四个方向
        int[][] dir = new int[][]{
            {1,0},{-1,0},{0,1},{0,-1}
        };
        for(int i=0;i<4;i++){
            dfs(grid,r+dir[i][0],c+dir[i][1]);
        }
    }
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        int sum=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    ++sum;
                    dfs(grid,i,j);
                }
            }
        }
        return sum;
    }
}
