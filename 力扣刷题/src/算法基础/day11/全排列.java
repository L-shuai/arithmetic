package 算法基础.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 全排列 {


    public static boolean[] vis2 = new boolean[5];
    public static int n=3;
    public static void main(String[] args) {
//        int n=5;
        List<Integer> perm = new ArrayList<>();
        test(perm,0);
    }

    public static void test(List<Integer> perm,int step){
        if(step==n){
//            ok
            for(int i=0;i<n;i++){
                System.out.print(perm.get(i)+" ");
            }
            System.out.println();
            return;
        }
//        尝试所有可能
        for(int i=0;i<n;i++){
            if(!vis2[i]){
                if(i==step){
                    System.out.print("-");
                }else{
                    System.out.print("+");
                }
                vis2[step]=true;
                perm.add(i+1);
                test(perm,step+1);
//                回溯
                perm.remove(perm.size()-1);
                vis2[step]=false;
            }
        }
    }

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
            ans.add(new ArrayList<>(perm));
            return;
        }
//        向下尝试所有可能
        for(int i=0;i<nums.length;i++){
            if(vis[i]==true){
//                已经尝试过了
                continue;
            }
            if(i>0 && nums[i]==nums[i-1] && !vis[i-1]){
                continue;
            }
//            向下层扩散
            perm.add(nums[i]);
            vis[i]=true;
            dfs(nums,ans,idx+1,perm);
//            否则回溯 回到上一个状态
            perm.remove(perm.size()-1);
            vis[i]=false;
        }
    }
}
