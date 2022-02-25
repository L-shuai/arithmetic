package 算法基础.day02;

public class 寻找峰值 {

    public int findPeakElement(int[] nums) {

        int len = nums.length;
        int res=0;
//        处理首尾
        if(len>1){
            if(nums[0]>nums[1])
                return 0;
            if(nums[len-1]>nums[len-2])
                return len-1;
        }
        for(int i=1;i<len-1;i++){
            if(nums[i]>nums[i-1] && nums[i]>nums[i+1]){
                res = i;
                break;
            }
        }
        return res;
    }
}
