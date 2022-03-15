package 算法基础.day11;

import java.util.*;

public class 全排列set {

    boolean[] vis;
    public List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> perm = new ArrayList<>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,ans,0,perm);
        return new ArrayList<>(ans);
    }

    public void dfs(int[] nums,Set<List<Integer>> ans,int idx,List<Integer> perm){
        if(idx==nums.length){
            ans.add(new ArrayList<>(perm));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(vis[i]==true){
                continue;
            }
            perm.add(nums[i]);
            vis[i]=true;
            dfs(nums,ans,idx+1,perm);
//            否i则回溯
            perm.remove(perm.size()-1);
            vis[i]=false;
        }

    }
}
