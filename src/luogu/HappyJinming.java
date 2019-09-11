package luogu;

import java.util.Scanner;

/**
 * @ClassName HappyJinming
 * @Description  P1060 开心的金明
 * @Author NebulaPort
 * @Date 2019/9/11 17:03
 */
public class HappyJinming {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int totalMoney=in.nextInt();
        int n=in.nextInt();
        in.nextLine();
        int[]v=new int[n+1];
        int[]w=new int[n+1];
        for (int i = 1; i <=n ; i++) {
            v[i]=in.nextInt();
            w[i]=in.nextInt();
            in.nextLine();
        }

        int[]f=new int[totalMoney+1];
        for (int i = 1; i <= n; i++) {
            for (int j = totalMoney; j >=v[i] ; j--) {
                f[j]=Math.max(f[j-v[i]]+v[i]*w[i],f[j]);
            }
        }
        System.out.println(f[totalMoney]);
    }
}
