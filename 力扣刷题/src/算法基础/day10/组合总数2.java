package 算法基础.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总数2 {
    List<List<Integer>>  ans = new ArrayList<>();
    List<Integer> perm = new ArrayList<>();
    boolean[] vis;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        vis = new boolean[candidates.length];
        Arrays.sort(candidates);
        dfs(candidates,target,perm,0);
        return ans;
    }

    public void dfs(int[] candidates,int target,List<Integer> perm,int idx){
//        if(idx==candidates.length){
////            idx越界
//            return;
//        }
        if(target==0){
//            找到
            ans.add(new ArrayList<>(perm));
            return;
        }
//        向下搜索所有可能
        for(int i=idx;i<candidates.length;i++){
//            去重 防止子集重复
            if(i>idx && candidates[i]==candidates[i-1]){
                continue;
            }

            if(target-candidates[i]>=0){
//                可以搜索
                perm.add(candidates[i]);
//                标记为已访问
//                vis[i]=true;
                dfs(candidates,target-candidates[i],perm,i+1);
//                否则回溯
                perm.remove(perm.size()-1);
//                vis[i]=false;
            }else{
                break;
            }
        }
    }
}
