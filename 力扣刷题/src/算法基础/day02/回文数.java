package 算法基础.day02;

public class 回文数 {

    public boolean isPalindrome2(int x) {
        boolean res = true;
        String n = Integer.toString(x);
        int len = n.length();
        for(int i=0;i<len/2;i++){
            if(n.charAt(i)!=n.charAt(len-1-i)){
                res = false;
                break;
            }
        }
        return res;
    }

    public boolean isPalindrome(int x) {

        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        boolean res = true;
        int tmp=0;
        while (x>tmp){
            tmp = tmp*10 +x%10;
            x/=10;
        }
        return x==tmp || x ==tmp/10;
    }
}
