package luogu.dp;

import java.util.Scanner;

/**
 * @ClassName PackingProb
 * @Description  P1049 装箱问题
 * @Author NebulaPort
 * @Date 2019/9/11 15:52
 */
public class PackingProb {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int v=in.nextInt();
        in.nextLine();
        int n=in.nextInt();
        in.nextLine();
        int[] w=new int[n+1];
        for (int i = 1; i <= n; i++) {
            w[i]=in.nextInt();
            in.nextLine();
        }
        int[] f=new int[v+1];
        for (int i = 1; i <=n ; i++) {
            for (int j = v; j >=w[i] ; j--) {

                f[j]=Math.max(f[j-w[i]]+w[i],f[j]);
            }
        }
        System.out.println(v-f[v]);
    }
}
