package 算法基础.day08;

import java.util.*;

/**
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 *
 *  graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
 */
public class 所有可能的路径 {

    List<List<Integer>> ans = new LinkedList<>();
    Stack<Integer> stack = new Stack<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        stack.push(0);
        dfs(graph,0,graph.length-1);
        return ans;

    }

    public void dfs(int[][] graph,int x,int n){
        if(x==n){
            ans.add(new ArrayList<Integer>(stack));
            return;
        }
        for(int i: graph[x]){
            stack.push(i);
            dfs(graph,i,n);
//            否则就要回溯  到上一个节点
            stack.pop();
        }
    }
}

