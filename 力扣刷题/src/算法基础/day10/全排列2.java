package 算法基础.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 全排列2 {
    boolean[] vis;
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,ans,0,perm);
        return ans;
    }

    public void dfs(int[] nums,List<List<Integer>> ans,int idx,List<Integer> perm){
        if(idx==nums.length){
//            递归终止
            ans.add(new ArrayList<>(perm));
            return;
        }
//        向下尝试所有可能
        for(int i=0;i<nums.length;i++){
            if(vis[i]){
//                已访问过
                continue;
            }
            if(i>0 && nums[i]==nums[i-1] && !vis[i-1]){
//                如果nums[i]==nums[i-1]  并且num[i-1]已经被尝试过
                continue;
            }
//            将当前节点加入栈
            perm.add(nums[i]);
            vis[i]=true;
            dfs(nums,ans,idx+1,perm);
//            否则 回溯
//            退回上一个节点状态
            vis[i]=false;
//            perm.remove(idx);
//
            perm.remove(perm.size()-1);
        }
    }
}
