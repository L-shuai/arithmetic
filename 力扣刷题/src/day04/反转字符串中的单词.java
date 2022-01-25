package day04;


/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
public class 反转字符串中的单词 {

    public static String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        for(int i=0;i<n;i++){

        }
        int left=0,right=1;
        while (left<right && right<n){

            if(arr[right]==' '){
                swap(arr,left,right-1);
                left = right+1;
                right = left+1;
            }else{
                right++;
                if(right==n){
                    swap(arr,left,n-1);
                }
            }

        }
//        swap(arr,0,2);

        return new String(arr);
    }

    public static void swap(char[] s,int a,int b){
        for(int i=a;i<=(a+b)/2;i++){
            char tmp = s[i];
            s[i]=s[b-i+a];
            s[b-i+a]=tmp;
        }
        for(int i=a;i<=(a+b)/2;i++){
//            System.out.print(s[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("You like me"));
    }
}
