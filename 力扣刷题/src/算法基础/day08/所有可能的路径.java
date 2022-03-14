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


    /**
     * BFS版本
     * @param graph
     * @return
     */
    public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        int size = graph.length;
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(List.of(0));
        while (!queue.isEmpty()) {
            int n = queue.size();
//            在该层进行遍历
            for (int i = 0; i < n; i++) {
                List<Integer> cul = queue.poll();
                int last = cul.get(cul.size() - 1);
//                判断是否符合条件
                if (last == size - 1) {
                    res.add(cul);
                    continue;
                }
                int[] dist = graph[last];
//                向下一层扩散
                for (int num : dist) {
//                    //                也可在此判断是否符合条件
                    List<Integer> list = new ArrayList<>(cul);
                    list.add(num);
                    queue.offer(list);
                }
            }
        }
        return res;
    }
    public List<List<Integer>> allPathsSourceTarget3(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        int size = graph.length;
        queue.offer(List.of(0));//将初始节点0加入队列
        while (!queue.isEmpty()){
            int n = queue.size();
//            遍历本层
            for(int j=0;j<n;j++){
//                队首出队
                List<Integer> cur = queue.poll();
//                获取上一个经过的点
                int last = cur.get(cur.size()-1);
                int[] dist = graph[last];
//                向下一层扩散
                for(int k:dist){
                    List<Integer> list = new ArrayList<>(cur);
                    list.add(k);
//                    判断是否为终点
                    if(k==size-1){
                        ans.add(list);
                    }
                    queue.offer(list);
                }
            }
        }
        return ans;
    }


}

