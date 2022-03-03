package 算法基础.day05;

/**
 * 给定一个正整数数组 nums和整数 k 。
 *
 * 请找出该数组内乘积小于 k 的连续的子数组的个数。
 */
public class 乘积小于K的子数组 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int res = 0;
        int len = nums.length;
        for(int i=0;i<len;i++){
//            从 i开始创建窗口  并移动
            int tmp=1;
            int j=i;
            while (j<len){
                tmp*=nums[j];
                if(tmp<k){
                    res++;
                }
                else{
                    break;
                }
                j++;
            }
        }
        return res;
    }

}
