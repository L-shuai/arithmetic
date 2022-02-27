package 算法基础.day04;

/**
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 */
public class 比较含退格的字符串 {

    public boolean backspaceCompare2(String s, String t) {
            return build(s).equals(build(t));
    }

    public String build(String str){
        StringBuffer ret = new StringBuffer();
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(c!='#'){
                ret.append(c);
            }else{
                if (ret.length() > 0) {
                    ret.deleteCharAt(ret.length() - 1);
                }
            }
        }
        return ret.toString();
    }


//    双指针做法
    public boolean backspaceCompare(String S, String T) {
            int a = S.length()-1;
            int b = T.length()-1;
            int s1=0;
            int s2=0;
            while (a>=0 || b>=0){
//                找到S第一个字母
                while (a>=0){
                    if(S.charAt(a)=='#'){
                        s1++;
                        a--;
                    }else if(s1>0){
                        a--;
                        s1--;
                    }else{
                        break;
                    }
                }

//                找到T第一个字母
                while (b>=0){
                    if(T.charAt(b)=='#'){
                        s2++;
                        b--;
                    }else if(s2>0){
                        b--;
                        s2--;
                    }else{
                        break;
                    }
                }

//                开始比较S T
                if(a>=0 && b>=0){
                    if(S.charAt(a)!=T.charAt(b)){
                        return false;
                    }
                }
                else{
                    if(a>=0 || b>=0){
                        return false;
                    }
                }
                a--;
                b--;

            }
            return true;
    }
}
