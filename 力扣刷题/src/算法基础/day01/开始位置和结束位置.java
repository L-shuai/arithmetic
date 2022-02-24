package 算法基础.day01;


/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 */
public class 开始位置和结束位置 {

    public static int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int a=-1,b=-1;
        for(int i=0;i<len;i++){
            if(a<0){
                if(nums[i]==target){
                    a=i;
                }
                else {
                    continue;
                }
            }else{
                if(nums[i]==target){
                        b=i;
                }else
                {
                    break;
                }
            }

        }
        return new int[]{a,b};

    }




    public static void main(String[] args) {

    }
}
