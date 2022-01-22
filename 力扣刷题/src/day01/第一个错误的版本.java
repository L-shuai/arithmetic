package day01;


/**
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 */
public class 第一个错误的版本 {


    /**
     * 具体地，将左右边界分别初始化为 11 和 nn，其中 nn 是给定的版本数量。设定左右边界之后，每次我们都依据左右边界找到其中间的版本，检查其是否为正确版本。如果该版本为正确版本，那么第一个错误的版本必然位于该版本的右侧，我们缩紧左边界；否则第一个错误的版本必然位于该版本及该版本的左侧，我们缩紧右边界。
     *
     * 这样我们每判断一次都可以缩紧一次边界，而每次缩紧时两边界距离将变为原来的一半，因此我们至多只需要缩紧 O(\log n)O(logn) 次。
     * @param n
     * @return
     */
//    public static int firstBadVersion(int n) {
//        if(n==1)
//            return 1;
//        int low = 1;
//        int high = n;
//        while (low<high){
//            int mid = low + (high-low)/2;
//            if(isBadVersion(mid)){
//                high = mid;
//            }
//            else{
//                low = mid+1;
//            }
//        }
//        return low;
//
//    }
    public static void main(String[] args) {

    }
}
