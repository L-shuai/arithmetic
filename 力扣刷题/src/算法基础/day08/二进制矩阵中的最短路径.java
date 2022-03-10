package 算法基础.day08;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
 *
 * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
 *
 * 路径途经的所有单元格都的值都是 0 。
 * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
 * 畅通路径的长度 是该路径途经的单元格总数。
 */
public class 二进制矩阵中的最短路径 {

    public int shortestPathBinaryMatrix2(int[][] grid) {
        int[][] dir = new int[][]{
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}
        };
        int m = grid.length;
        int n = m;
//        标记思否访问过
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<int[]>();
        int dis = 1;//步数
        if (grid[0][0] != 0) {
//            不满足起点为0
            return -1;//没有方案
        }
        if (m == 1) {
            return 1;//一步就可到达
        }
        queue.offer(new int[]{0, 0});//将起点加入队列
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();//将队首的元素出队
                int a = poll[0];
                int b = poll[1];
//                从[a,b]点开始向8个方向扩展
                for (int j = 0; j < 8; j++) {
                    int na = a + dir[j][0];
                    int nb = b + dir[j][1];
                    if (na >= 0 && na < m && nb >= 0 && nb < m && grid[na][nb] == 0 && !vis[na][nb]) {
//                        如果到达终点了
                        if (na == m - 1 && nb == m - 1) {
                            return dis + 1;
                        }
//                        否则就将扩展的点加入队列
                        queue.offer(new int[]{na, nb});
//                        将扩展的点标记为以访问
                        vis[na][nb] = true;
                    }
                }
            }
//            每一圈将dis+1
            dis += 1;
        }

//        否则就返回-1
        return -1;
    }


    /**
     * 另一种比较传统的bfs
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix4(int[][] grid) {
        int[][] dir = new int[][]{
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}
        };
//        队列
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
//        int dis=1;//步数
        if(grid[0][0]!=0){
            return -1;//不可行
        }
        if(m==1){
            return 1;//一步就可到达
        }
//        将第一个元素加入队列
        queue.offer(new int[]{0,0,1});
//        将第一个元素标记为已访问过
        grid[0][0]=1;
        while (!queue.isEmpty()){
            int[] tmp = queue.poll();//出队
            if(tmp[0]==m-1 && tmp[1]==m-1){
//                如果已经到达终点
//                return dis+1;
                return tmp[2];
            }
//            否则就向四周扩展
            for(int i=0;i<8;i++){
                int na = tmp[0]+dir[i][0];
                int nb = tmp[1]+dir[i][1];
                if (na >= 0 && na < m && nb >= 0 && nb < m && grid[na][nb] == 0 ) {
                    queue.offer(new int[]{na,nb,tmp[2]+1});
                    grid[na][nb]=1;//标记为已走过
                }
            }
//            dis+=1;
        }

//        否则就是不可行
        return -1;
    }

    /**
     * 自己写的bfs
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dir = new int[][]{
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}
        };
//        队列
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
//        int dis=1;//步数
        if (grid[0][0] != 0) {
            return -1;//不可行
        }
        if (m == 1) {
            return 1;//一步就可到达
        }

        int dis=1;
//        将第一个点加入队列
        queue.offer(new int[]{0,0});
//        将第一个点标记为走过
        grid[0][0]=1;
        while (!queue.isEmpty()){
            dis++;//层数增加
//            遍历该层
            int size = queue.size();
            for(int i=0;i<size;i++){
//                队首出队
                int[] tmp = queue.poll();
//                向四周扩散
                for(int j=0;j<8;j++){
                    int na = tmp[0]+dir[j][0];
                    int nb = tmp[1]+dir[j][1];
                    if (na >= 0 && na < m && nb >= 0 && nb < m && grid[na][nb] == 0 ) {
//                        如果到达终点了
                        if (na == m - 1 && nb == m - 1) {
                            return dis;
                        }
//                        否则
                        queue.offer(new int[]{na,nb});
                        grid[na][nb]=1;//标记为已走过
                    }
                }
            }

        }

        return -1;
    }

}