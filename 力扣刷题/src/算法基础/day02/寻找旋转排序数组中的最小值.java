package 算法基础.day02;

public class 寻找旋转排序数组中的最小值 {

    public int findMin(int[] nums) {
        int res=0;
        int len = nums.length;
        int p = len-1;
//        寻找p
        for(int i=0;i<len-1;i++){
            if(nums[i]>nums[i+1]){
                p=i;
                break;
            }
        }
//        寻找两段的较小的一段
        return p==len-1?nums[0]:(nums[0]<nums[p+1]?nums[0]:nums[p+1]);


    }

    public static void main(String[] args) {

    }
}
