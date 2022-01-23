package day02;


/**
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class 轮转数组 {

    public static void rotate1(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            int index = (i+k)%n;
            ans[index] = nums[i];
        }
        System.arraycopy(ans,0,nums,0,n);
//        nums = ans;  //java数组

    }


    /**
     * 反转数组
     * @param nums
     * @param k
     *
     * 该方法基于如下的事实：当我们将数组的元素向右移动 kk 次后，尾部 k\bmod nkmodn 个元素会移动至数组头部，其余元素向后移动 k\bmod nkmodn 个位置。
     *
     * 该方法为数组的翻转：我们可以先将所有元素翻转，这样尾部的 k\bmod nkmodn 个元素就被移至数组头部，然后我们再翻转 [0, k\bmod n-1][0,kmodn−1] 区间的元素和 [k\bmod n, n-1][kmodn,n−1] 区间的元素即能得到最后的答案。
     */
    public static void rotate2(int[] nums, int k) {

        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

    }

    public static void reverse(int[] nums,int start,int end){
        int tmp=0;
        while (start<end){//不需要等号，等于的时候，不需要处理
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }


        public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate1(nums,3);
    }
}
