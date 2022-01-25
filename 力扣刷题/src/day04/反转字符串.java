package day04;

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
