package 算法基础.day05;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）
 */
public class 找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        if(lenS<lenP){
            return new LinkedList<>();
        }
        List<Integer> res = new LinkedList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
//        统计p和s的第一个初始窗口的字母频数是否相同
        for(int i=0;i<lenP;i++){
            ++sCount[s.charAt(i)-'a'];
            ++pCount[p.charAt(i)-'a'];
        }
        if(Arrays.equals(sCount,pCount)){
            res.add(0);//s的第一个窗口和p一样，将索引 0加入到结果中
        }
        for(int i=0;i<lenS-lenP;i++){
            --sCount[s.charAt(i)-'a'];//窗口右移一位
            ++sCount[s.charAt(i+lenP)-'a'];
            if(Arrays.equals(sCount,pCount)){
                res.add(i+1);
            }
        }
        return res;
    }

}
