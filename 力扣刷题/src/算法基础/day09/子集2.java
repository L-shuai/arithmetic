package 算法基础.day09;

import java.util.*;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 */
public class 子集2 {
    Set<List<Integer>> ans = new HashSet<>();
//    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> t = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(0,nums);
        return new ArrayList<>(ans);
    }


    public void dfs(int cur,int[] nums){
        if(cur==nums.length){
            ans.add(new ArrayList<Integer>(t));
            return;
        }
//        考虑将当前cur加入t中
        t.add(nums[cur]);
        dfs(cur+1,nums);

//        考虑不选择cur
        t.remove(t.size()-1);
        dfs(cur+1,nums);

    }
}
