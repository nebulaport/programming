package camp;

import java.util.Scanner;

/**
 * @ClassName BinPacking
 * @Description 背包问题1
 * 描述
 * n种物品，每种物品有相应的价值和体积，同时物品还分为两类，
 * 一类是“单个物品”，即该种物品只有一个；
 * 一类是“多个物品”，即该种物品有无限个。
 * 现在你有一个体积为V的背包，那么该装些什么物品到背包里使得价值之和最大呢？
 *
 * 输入
 * 第一行包含两个正整数n,V。
 * 接下来n行，每行代表一种物品。每行的第一个数字表示该物品的种类（若为0表示“单个物品”，若为1表示“多个物品”），
 * 第二个数字表示该物品的价值，第三个数字表示该物品的体积。
 *
 * 输出
 * 输出一个整数，表示最大的价值之和。
 * @Author NebulaPort
 * @Date 2019/8/30 16:55
 */
public class BinPacking {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        final int V=in.nextInt();
        in.nextLine();

        int[] type=new int[n+1];
        int[] w=new int[n+1];
        int[] v=new int[n+1];
        for (int i = 1; i <= n; i++) {
            type[i]=in.nextInt();
            w[i]=in.nextInt();
            v[i]=in.nextInt();
            in.nextLine();
        }


        System.out.println(getAns(n,V,type,w,v));

    }

    private static int getAns(int n, int V, int[] type, int[] w, int[] v) {
        int[] dp = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            dp[i]=0;
        }

        for (int i = 1; i <= n; i++) {

            if (type[i] == 0) {
                //01背包,倒序枚举
                for (int j = V; j >= v[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);

                }

            } else if (type[i]==1){
                //完全背包，顺序枚举
                for (int j = v[i]; j <= V; j++) {
                    dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);

                }
            }
        }
        return dp[V];
    }
}
