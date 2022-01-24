package day03;

public class 两数之和or输入有序数组 {
    public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(numbers[j]==target-numbers[i]){
                    return new int[]{i+1,j+1};
                }
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] numbers, int target) {
        int n = numbers.length;
        int left=0,right=1;
        while (left<n&&right<n){
            if(numbers[right]==target-numbers[left]){
                return new int[]{left+1,right+1};
            }else if(numbers[right]<target-numbers[left]){
                right++;
            }else if(numbers[right]>target-numbers[left]){
                left++;
                right=left+1;
            }
            if(right==n){
                left++;
                right=left+1;
            }
        }
        return null;
    }

    /**
     * 二分查找
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] numbers, int target) {
        int n = numbers.length;
        for(int i=0;i<n;i++){
//            固定num[i]，寻找target-num[i]
            int left=i+1;
            int right=n-1;
            while (left<=right){
                int mid = left+(right-left)/2;
                if(numbers[mid]==target-numbers[i]){
                    return new int[]{i+1,mid+1};
                }else if(numbers[mid]<target-numbers[i]){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }
        }
        return null;

    }

    /**
     * 双指针
     * 初始时两个指针分别指向第一个元素位置和最后一个元素的位置。每次计算两个指针指向的两个元素之和，并和目标值比较。如果两个元素之和等于目标值，则发现了唯一解。如果两个元素之和小于目标值，则将左侧指针右移一位。如果两个元素之和大于目标值，则将右侧指针左移一位。移动指针之后，重复上述操作，直到找到答案。
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum4(int[] numbers, int target) {
        int left = 0,right = numbers.length-1;
        while (left<right){
            if(numbers[left]==target-numbers[right]){
                return new int[]{left+1,right+1};
            }else if(numbers[left]+numbers[right]<target){
                left++;
            }
            else{
                right--;
            }
        }
        return null;
    }


        public static void main(String[] args) {


    }
}
