package luogu;

import java.util.Scanner;

/**
 * @ClassName SeriesSum
 * @Description  P1035 级数求和
 * 已知：S_n= 1+1/2+1/3+…+1/n S * n
 * ​	 =1+1/2+1/3+…+1/n。显然对于任意一个整数KK，当nn足够大的时候，S_nS
 * n大于KK。
 *
 * 现给出一个整数KK（1 \le k \le 151≤k≤15），要求计算出一个最小的nn；使得S_n>KSn>K。
 * @Author NebulaPort
 * @Date 2019/9/5 9:42
 */
public class SeriesSum {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int k=in.nextInt();
        double s=0;
        int n=0;
        while (s<=k){
            n++;
            s+=(double) 1/n;

        }
        System.out.println(n);
    }
}
