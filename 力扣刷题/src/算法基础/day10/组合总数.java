package 算法基础.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 */
public class 组合总数 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> perm = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
//        dfs(candidates,target,ans,perm,0);
        backtrack(candidates,target,ans,perm,0);
        return ans;
    }

    /**
     * 定义递归函数 dfs(target, combine, idx) 表示当前在 candidates 数组的第 idx 位，
     * 还剩 target 要组合，已经组合的列表为 combine。
     * 递归的终止条件为 target <= 0 或者 candidates 数组被全部用完。
     * @param candidates
     * @param target
     * @param ans
     * @param prem
     * @param idx
     */
    public void dfs(int[] candidates,int target,List<List<Integer>> ans,List<Integer> prem,int idx){
        if(idx==candidates.length){
//            idx已经越界
            return;
        }
        if(target==0){
//            已找到符合条件的组合
            ans.add(new ArrayList<>(perm));
            return;
        }

//        每个节点向下搜索有两种选择：  将当前idx对应节点加入perm    或者   直接跳过该点
//        1，跳过当前点
        dfs(candidates,target,ans,perm,idx+1);
//        2，将当前点加入perm
        if(target-candidates[idx]>=0){
            perm.add(candidates[idx]);
            dfs(candidates,target-candidates[idx],ans,perm,idx);
//            若未成功  则回溯
            perm.remove(perm.size()-1);
        }

    }

    public void backtrack(int[] candidates,int target,List<List<Integer>> ans,List<Integer> prem,int idx){
        if(idx==candidates.length){
//            idx越界
            return;
        }
        if(target==0){
//            已找到符合条件的组合
            ans.add(new ArrayList<>(perm));
            return;
        }
//        向下尝试所有可能的节点
        for(int i=idx;i<candidates.length;i++){
            if(target-candidates[i]>=0){
//                有搜索空间
                perm.add(candidates[i]);
//                每个元素可以无限被选取，所以为i而不是i+1
                backtrack(candidates,target-candidates[i],ans,perm,i);
//                否则回溯
                perm.remove(perm.size()-1);
            }else{
//                直接跳过
                break;
            }
        }
    }
}
