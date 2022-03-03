package 算法基础.day04;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 */
public class 盛最多水的容器 {

    public int maxArea(int[] height) {
        int res = 0;
        int len = height.length;
        int left=0,right=len-1;
        while (left<right){
            int tmp = (right-left)*Math.min(height[left],height[right]);
            if(tmp>res){
                res = tmp;
            }
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return res;

    }
}
