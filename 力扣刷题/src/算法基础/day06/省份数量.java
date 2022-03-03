package 算法基础.day06;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 *
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 *
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 *
 * 返回矩阵中 省份 的数量。
 */
public class 省份数量 {

    public int findCircleNum2(int[][] isConnected) {
        int provinces = isConnected.length;//省份的总数
        boolean[] isVisited = new boolean[provinces];//是否被访问过
        int sum=0;
        for(int i=0;i<provinces;i++){
            if(!isVisited[i]){
                //如果没被访问，
                dfs(isConnected,isVisited,provinces,i);
                sum++;
            }
        }
        return sum;
    }

    private void dfs(int[][] isConnected, boolean[] isVisited, int provinces, int i) {
        for(int j=0;j<provinces;j++){
            if(!isVisited[j] && isConnected[i][j]==1){
                isVisited[j]=true;
                dfs(isConnected,isVisited,provinces,j);
            }
        }
    }

    /**
     * 广度优先搜索
     */
    public int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        int sum=0;
        boolean[] visit = new boolean[provinces];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<provinces;i++){
            if(!visit[i]){
                queue.offer(i);
                while (!queue.isEmpty()){
                    int j = queue.poll();
                    visit[j]=true;
                    for(int k=0;k<provinces;k++){
                        if(!visit[k] && isConnected[j][k]==1){
                            queue.offer(k);
                        }
                    }
                }
                sum++;
            }
        }
        return sum;
    }

}
