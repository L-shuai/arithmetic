package 算法基础.day04;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而 secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。
 *
 * 返回这 两个区间列表的交集 。
 *
 * 形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b 。
 *
 * 两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。
 */
public class 区间列表的交集 {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        /*
        双指针:
        指针i表示A集合中区间的索引,那么A[i][0]和A[i][1]分别表示区间A[i]的左右边界
        指针j表示B集合中区间的索引,那么B[j][0]和B[j][1]分别表示区间B[j]的左右边界
        左边界start取两个区间左边界较大值,右边界end取两个区间右界较小值
        若start<=end则可以形成区间,将[start,end]加入结果
        指针移动:看谁的右边界较小,较小的右边界后面不可能有交集了,因此根据右边界大小移动i与j指针
        具体地:A[i][1]>B[j][1],j++;A[i][1]<B[j][1],i++
        循环至两个区间组都到达末尾就结束
        */
        List<int[]> list = new LinkedList<>();
        int i=0,j=0;
        int lenA = firstList.length;
        int lenB = secondList.length;
        while (i<lenA && j<lenB){
//            求出两个数组中较大的左边界和较小的右边界
            int start = Math.max(firstList[i][0],secondList[j][0]);
            int end = Math.min(firstList[i][1],secondList[j][1]);
            if(start<=end){
//                符合条件  加入list
                list.add(new int[]{start,end});
            }
//            移动指针  哪个右边界较小  就向后移动一位
            if(firstList[i][1]<secondList[j][1]){
                i++;
            }else{
                j++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
