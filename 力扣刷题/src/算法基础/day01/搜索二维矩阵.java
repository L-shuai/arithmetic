package 算法基础.day01;


/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 */
public class 搜索二维矩阵 {

    /**
     * 思路：比较每一行的第一个元素，将范围缩小
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean res = false;
        int p = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int low=0,high=n-1;

        for(int i=0;i<m;i++){
            if(matrix[i][0]<=target && matrix[i][n-1]>=target){
                p =i;
                break;
            }
        }
        while (low<=high){
            int mid = low+(high-low)/2;
            if(matrix[p][mid]==target){
                res = true;
                break;
            }
            else if(matrix[p][mid]<target)
            {
                low = mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
