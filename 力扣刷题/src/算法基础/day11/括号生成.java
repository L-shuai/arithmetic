package 算法基础.day11;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 */
public class 括号生成 {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans,new StringBuffer(),n,n);
        return ans;
    }
    public void backtrack(List<String> ans,StringBuffer current,int left,int right){
        if(left==0 && right==0){
            ans.add(current.toString());
            return;
        }
//        向下一层扩散
//        如果剩余的左括号和右括号数量相同，则下一个只能添加左括号
        if(left==right){
            current.append('(');
            backtrack(ans,current,left-1,right);
            current.deleteCharAt(current.length()-1);

        }else if(left<right){
//            如果剩余的左括号小于右括号，则下一个可以用左括号也可以用右括号
            if(left>0){
                current.append('(');
                backtrack(ans,current,left-1,right);
//                否则回溯
                current.deleteCharAt(current.length()-1);
            }
            current.append(')');
            backtrack(ans,current,left,right-1);
            current.deleteCharAt(current.length()-1);

        }
    }




    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<>();
        backtrack2(ans,new StringBuffer(),0,0,n);
        return ans;
    }

    /**
     * 如果左括号数量不大于 nn，我们可以放一个左括号。
     * 如果右括号数量小于左括号的数量，我们可以放一个右括号。
     * @param ans
     * @param current
     * @param left
     * @param right
     * @param n
     */
    public void backtrack2(List<String> ans,StringBuffer current,int left,int right,int n){
        if(left==n && right==n){
//            如果左括号和右括号的数量都够了
            ans.add(current.toString());
            return;
        }
//        向下一层扩散  尝试添加左/右括号
//        要 先添加左括号
        if(left<n){
            current.append('(');
//            递归
            backtrack2(ans,current,left+1,right,n);
//            否则回溯  回到上一个状态
            current.deleteCharAt(current.length()-1);
        }
//        添加右括号
        /**
         * 要确保如果右括号数小于左括号，再添加左括号
         */
        if(right<left){
            current.append(')');
//            递归
            backtrack2(ans,current,left,right+1,n);
//            回溯  回到上一个状态
            current.deleteCharAt(current.length()-1);
        }
    }
}
