package day02;


/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 归并排序（双指针）
 *
 *
 * 思路与算法
 *
 * 方法一没有利用「数组 \textit{nums}nums 已经按照升序排序」这个条件。显然，如果数组 \textit{nums}nums 中的所有数都是非负数，那么将每个数平方后，数组仍然保持升序；如果数组 \textit{nums}nums 中的所有数都是负数，那么将每个数平方后，数组会保持降序。
 *
 * 这样一来，如果我们能够找到数组 \textit{nums}nums 中负数与非负数的分界线，那么就可以用类似「归并排序」的方法了。具体地，我们设 \textit{neg}neg 为数组 \textit{nums}nums 中负数与非负数的分界线，也就是说，\textit{nums}[0]nums[0] 到 \textit{nums}[\textit{neg}]nums[neg] 均为负数，而 \textit{nums}[\textit{neg}+1]nums[neg+1] 到 \textit{nums}[n-1]nums[n−1] 均为非负数。当我们将数组 \textit{nums}nums 中的数平方后，那么 \textit{nums}[0]nums[0] 到 \textit{nums}[\textit{neg}]nums[neg] 单调递减，\textit{nums}[\textit{neg}+1]nums[neg+1] 到 \textit{nums}[n-1]nums[n−1] 单调递增。
 *
 * 由于我们得到了两个已经有序的子数组，因此就可以使用归并的方法进行排序了。具体地，使用两个指针分别指向位置 \textit{neg}neg 和 \textit{neg}+1neg+1，每次比较两个指针对应的数，选择较小的那个放入答案并移动指针。当某一指针移至边界时，将另一指针还未遍历到的数依次放入答案。
 */
public class 有序数组的平方 {

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
//        先找出负数和正数的分界点
        int neg = -1;
        for(int i=0;i<n;i++){
            if(nums[i]<0)
                neg=i;
            else
                break;
        }

        int index=0;
//        双指针
        int i=neg;
        int j = neg+1;
        while (i>=0 || j<n){
            if(i<0){
//                左指针已经到头了
//                将右指针对应的都加到ans
                ans[index] = nums[j]*nums[j];
                j++;
            }else if(j>=n){
//                右指针到头了  将左指针对应的都加到ans
                ans[index] = nums[i]*nums[i];
                i--;
            }else if(nums[i]*nums[i]<nums[j]*nums[j]){
//                左指针更小
                ans[index] = nums[i]*nums[i];
                i--;
            }else{
//                右指针更小
                ans[index] = nums[j]*nums[j];
                j++;
            }
            index++;
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
