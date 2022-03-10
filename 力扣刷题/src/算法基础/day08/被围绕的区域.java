package 算法基础.day08;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 */
public class 被围绕的区域 {
    int n,m;

    /**
     * DFS解法
     * @param board
     */
    public void solve2(char[][] board) {
        n=board.length;
        m = board[0].length;
        if(n==0)
            return;
//        遍历边界
        for(int i=0;i<n;i++){
            dfs(board,i,0);
            dfs(board,i,m-1);
        }
        for(int i=0;i<m;i++){
            dfs(board,0,i);
            dfs(board,n-1,i);
        }

//        修正
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
//                处理边界时  被标记为A了，说明这些都是与边界的0相邻的，不符合要求，需要还原为0
                if(board[i][j]=='A'){
                    board[i][j]='O';
                }else if(board[i][j]=='O'){
//                    原始矩阵中的0，未被标记过，符合要求，要被修改为X
                    board[i][j]='X';
                }
            }
        }

    }

    public void dfs(char[][] board,int x,int y){
        if(x<0 || x>=n|| y<0 || y>=m || board[x][y]!='O'){
            return;
        }
//        将与x y相邻接的所有0都标记为A
        board[x][y]='A';
        dfs(board,x+1,y);
        dfs(board,x-1,y);
        dfs(board,x,y+1);
        dfs(board,x,y-1);
    }


    /**
     * BFS解法
     * 我们可以使用广度优先搜索实现标记操作。在下面的代码中，我们把标记过的字母 O 修改为字母 A。
     * @param board
     */
    public void solve(char[][] board) {
        int[][] dir = new int[][]{
                {1,0},{-1,0},{0,1},{0,-1}
        };//四个方向
        int n=board.length;
        if(n==0)
            return;
        int m = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(board[i][0]=='O'){
                queue.offer(new int[]{i,0});
                board[i][0]='A';
            }
            if(board[i][m-1]=='O'){
                queue.offer(new int[]{i,m-1});
                board[i][m-1]='A';
            }
        }

        for(int i=0;i<m;i++){
            if(board[0][i]=='O'){
                queue.offer(new int[]{0,i});
                board[0][i]='A';
            }
            if(board[n-1][i]=='O'){
                queue.offer(new int[]{n-1,i});
                board[n-1][i]='A';
            }
        }
//        出队列
        while (!queue.isEmpty()){
            int[] tmp = queue.poll();
//            向四周扩散
            for(int i=0;i<4;i++){
                int na = tmp[0]+dir[i][0];
                int nb = tmp[1]+dir[i][1];
                if(na>=0 && na<n && nb>=0 && nb<m && board[na][nb]=='O'){
                    board[na][nb]='A';
                    queue.offer(new int[]{na,nb});
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='A'){
//                    如果前面被标记为A ，说明是边界的O   不符合要求，需要还原为O
                    board[i][j]='O';
                }else if(board[i][j]=='O'){
//                    没别标记的O，符合要求，需要改为X
                    board[i][j]='X';
                }
            }
        }
    }
}
