package 算法基础.day11;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用
 */
public class 单词搜索 {

    public boolean exist(char[][] board, String word) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0)){

                    if(dfs(board,word,i,j,0,vis)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,String word,int i,int j,int k,boolean[][] vis){
        if(k==word.length()){
            return true;
        }
        if(board[i][j]!=word.charAt(k)){
            return false;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length ||vis[i][j]) {
            return false;
        }
        int[][] dir = {
                {1,0},{-1,0},{0,1},{0,-1}
        };
//        vis[i][j]=true;
        for(int a=0;a<4;a++){
            int x = i+dir[a][0];
            int y = j+dir[a][1];
//            验证是否超出范围

            vis[i][j]=true;
            if(dfs(board,word,x,y,k+1,vis))
                return true;
//            回溯
            vis[i][j]=false;
        }
        return false;

    }

    public boolean dfs3(char[][] board,String word,int i,int j,int k,boolean[][] vis){
        if(k==word.length()){
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length ||vis[i][j]) {
            return false;
        }
        if(word.charAt(k)!=board[i][j]){
            return false;
        }

        int[][] dir = {
                {1,0},{-1,0},{0,1},{0,-1}
        };
        boolean res = false;
        for(int a=0;a<4;a++){
            vis[i][j]=true;
            if(dfs3(board, word, i+dir[a][0], j+dir[a][1], k + 1,vis)){
                return true;
            }
            vis[i][j]=false;
        }

//        vis[i][j]=false;
        return false;

    }


    public boolean dfs2(char[][] board,String word,int i,int j,int k,boolean[][] vis){
        if(k==word.length()){
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length ||vis[i][j]) {
            return false;
        }
        if(word.charAt(k)!=board[i][j]){
            return false;
        }
        vis[i][j]=true;
        boolean res = dfs2(board, word, i + 1, j, k + 1,vis) ||
                dfs2(board, word, i - 1, j, k + 1,vis) ||
                dfs2(board, word, i, j + 1, k + 1,vis) ||
                dfs2(board, word, i, j - 1, k + 1,vis);
        vis[i][j]=false;
        return res;

    }



}
