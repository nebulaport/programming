package luogu;

import java.util.Scanner;

/**
 * @ClassName MatchstickEquation
 * @Description P1149 火柴棒等式
 * 给你n根火柴棍，你可以拼出多少个形如“A+B=CA+B=C”的等式？等式中的AA、BB、CC是用火柴棍拼出的整数（若该数非零，则最高位不能是00）。
 * 用火柴棍拼数字0-90−9的拼法如图所示：
 * 注意：
 * 加号与等号各自需要两根火柴棍
 * 如果A≠BA≠B，则A+B=CA+B=C与B+A=CB+A=C视为不同的等式(A,B,C>=0A,B,C>=0)
 * nn根火柴棍必须全部用上
 * @Author NebulaPort
 * @Date 2019/9/17 21:53
 */
public class MatchstickEquation {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[]a=new int[20001];
        int m[]={6,2,5,5,4,5,6,3,7,6};
        a[0]=6;
        for (int i = 1; i <=2000 ; i++) {
            int j=i;
            while (j>=1){
                a[i]=a[i]+m[j%10];
                j=j/10;
            }
        }
        int ans=0;
        for (int i = 0; i <=1000 ; i++) {
            for (int j = 0; j <=1000 ; j++) {
                if(a[i]+a[j]+a[i+j]+4==n){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
