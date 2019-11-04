package leetcode;

/**
 * @ClassName Reverse
 * @Description 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * @Author NebulaPort
 * @Date 2019/11/4 13:18
 */
public class Reverse {
    public int reverse(int x) {
        int ans=0;
        while(x!=0){
            if (ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE / 10 && x%10 > 7)) return 0;
            if (ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE / 10 && x%10 < -8)) return 0;

            ans=ans*10+x%10;
            x=x/10;
        }
        return ans;
    }
}
