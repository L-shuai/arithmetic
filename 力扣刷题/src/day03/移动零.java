package day03;

public class 移动零 {
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int m =0;
        int index=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                m++;
            }else{
                nums[index]=nums[i];
                index++;
            }
        }
        for(int i=n-m;i<n;i++){
            nums[i]=0;
        }
    }


    /**
     * 使用双指针，左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
     *
     * 右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移。
     *
     * 注意到以下性质：
     *
     * 左指针左边均为非零数；
     *
     * 右指针左边直到左指针处均为零。
     *
     * 因此每次交换，都是将左指针的零与右指针的非零数交换，且非零数的相对顺序并未改变。
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        int n = nums.length;
        int left=0,right=0;
        while (right<n){
            if(nums[right]!=0){
                swap(nums,left,right);
                left++;
            }
            right++;
        }
    }

    public static void swap(int[] nums,int a,int b){
        int tmp=nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

        public static void main(String[] args) {

    }
}
