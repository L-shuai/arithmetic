package day04;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 */
public class 反转字符串 {
    public static void reverseString(char[] s) {
        int n = s.length;
        for(int i=0;i<n/2;i++){
            char tmp = s[i];
            s[i]=s[n-i-1];
            s[n-i-1]=tmp;
        }

    }


    public static void main(String[] args) {
        char[] s= {'h','e','l'};
        reverseString(s);
    }
}
