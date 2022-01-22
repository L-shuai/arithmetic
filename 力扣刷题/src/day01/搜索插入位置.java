package day01;


public class 搜索插入位置 {


    public static int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left<=right){
            mid = left+(right-left)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid]>target)
                right=mid-1;
            if(nums[mid]<target)
                left=mid+1;
        }
        return left;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums,2));
    }
}
