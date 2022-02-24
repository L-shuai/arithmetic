package 算法基础.day01;


/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 */
public class 搜索旋转排序数组 {

    public static int search2(int[] nums, int target) {
        int res = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                res = i;
                break;
            }
        }
        return res;
    }

    /**
     * 时间复杂度log n
     *
     * 因为旋转了，所以被分成两部分，先确定target属于哪一部分，再做二分查找
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        int a=-1,b=-1;
        int low=0,high=len-1;
        int res = -1;
        int p=len-1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                p=i;
                break;
            }
        }
        if(target<nums[0]){
            //target属于右半部分  p+1   len
            low = p+1;
            high = len-1;

        }
        else{
//            target属于左半部分 0   p
            high = p;
        }

        while (low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                res = mid;
                break;
            }
            else if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return res;


    }

    public static void main(String[] args) {

    }
}
