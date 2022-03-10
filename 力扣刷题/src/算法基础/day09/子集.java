package 算法基础.day09;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class 子集 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> t = new ArrayList<>();
    public List<List<Integer>> subsets2(int[] nums) {
        dfs(0,nums);
        return ans;
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

    /**
     * 动态规划解法：
     *  包含当前数的子集组合=上一个数的获得的每一个子集组合+当前数。
     *  所有子集=遍历的每一个数的获得的子集组合的合集。
     *  f(nums[i])=f(nums[ i-1]) add nums[i] + f(nums[i-1]) 。
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> t = new LinkedList<>();
        ans.add(t);
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            int  size = t.size();
            for(int j=0;j<size;j++){
//                上一个子集  加上当前的num
                List<Integer> tmp = ans.get(j);
                List<Integer> sub = new ArrayList<>(tmp);
                sub.add(num);
                ans.add(sub);
            }
        }
        return ans;
    }
}
