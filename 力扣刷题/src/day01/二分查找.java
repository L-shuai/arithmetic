package day01;


/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class 二分查找 {



    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid]>target)
                high=mid-1;
            if(nums[mid]<target)
                low = mid+1;
        }
        return -1;

    }

        /**
         * 效率低下
         * @param nums
         * @param target
         * @return
         */
    public static int search2(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(search(nums,9));;
    }
}
