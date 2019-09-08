package luogu;

import java.util.Scanner;

/**
 * @ClassName CalculateNum
 * @Description  P1028 数的计算
 * 我们要求找出具有下列性质数的个数(包含输入的自然数nn):
 *
 * 先输入一个自然数nn(n \le 1000n≤1000),然后对此自然数按照如下方法进行处理:
 *
 * 不作任何处理;
 * 在它的左边加上一个自然数,但该自然数不能超过原数的一半;
 * 加上数后,继续按此规则进行处理,直到不能再加自然数为止.
 * @Author NebulaPort
 * @Date 2019/9/7 14:44
 */
public class CalculateNum {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();

        int[]dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for (int i = 2; i <=n ; i++) {
            if (i%2==0){
                dp[i]=dp[i-1]+dp[i/2];
            }else{
                dp[i]=dp[i-1];
            }

        }
        System.out.println(dp[n]);
    }
}
