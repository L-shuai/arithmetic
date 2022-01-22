package day01;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 */


public class 两数之和 {

    /**
     * 暴力遍历也是可以的，复杂度n2，不太好
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
//                    return "["+nums[i]+","+nums[j]+"]";
                    res[0]=i;
                    res[1]=j;
//                    System.out.println(res);
                    return res;
                }
//
            }
        }
        return res;

    }

    /**
     * 由于哈希查找的时间复杂度为 O(1)O(1)，所以可以利用哈希容器 map 降低时间复杂度
     * 遍历数组 nums，i 为当前下标，每个值都判断map中是否存在 target-nums[i] 的 key 值
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("no solution!");
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        System.out.println(twoSum2(nums,6)[0]+"  "+twoSum2(nums,6)[1]);;
    }
}
