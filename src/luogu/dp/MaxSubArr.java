package luogu.dp;

import java.util.Scanner;

/**
 * @ClassName MaxSubArr
 * @Description P1115 最大子段和
 * @Author NebulaPort
 * @Date 2019/9/20 16:01
 */
public class MaxSubArr {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        for (int i = 0; i <n ; i++) {
            a[i]=in.nextInt();
        }

        int max= a[0];
        int sum=a[0];
        for (int i = 1; i <n ; i++) {
            sum=Math.max(sum+a[i],a[i]);
            max=Math.max(max,sum);
        }
        System.out.println(max);

    }
}
