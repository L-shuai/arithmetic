package 算法基础.day05;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class 长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int res=Integer.MAX_VALUE;
//        从i开始创建窗口
        for(int i=0;i<len;i++){
            int sum=0;
            int j=i;
            while (j<len){
                sum+=nums[j];
                if(sum>=target){
                    res = Math.min(res,j-i+1);
                    break;
                }
                j++;
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }

}
