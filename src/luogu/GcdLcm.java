package luogu;

import java.util.Scanner;

/**
 * @ClassName GcdLcm
 * @Description  P1029 最大公约数和最小公倍数问题
 * @Author NebulaPort
 * @Date 2019/9/7 15:49
 */
public class GcdLcm {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int x=in.nextInt();
        int y=in.nextInt();
        int ans=0;
        for (int i = x; i <= Math.sqrt((double)x*y); i=i+x) {
            if ((x*y)%i==0&&gcd(i,x*y/i)==x){
                ans++;
            }
        }
        System.out.println(ans*2);
    }

    //求最大公约数
    private static int gcd(int a, int b){
        if (b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}
