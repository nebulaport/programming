package luogu;

import java.util.Scanner;

/**
 * @ClassName FlipTheCoin
 * @Description  P1146 硬币翻转
 * 在桌面上有一排硬币，共NN枚，每一枚硬币均为正面朝上。
 * 现在要把所有的硬币翻转成反面朝上，
 * 规则是每次可翻转任意N-1N−1枚硬币（正面向上的被翻转为反面向上，反之亦然）。
 * 求一个最短的操作序列（将每次翻转N-1枚硬币成为一次操作）。
 * @Author NebulaPort
 * @Date 2019/10/12 15:53
 */
public class FlipTheCoin {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        System.out.println(n);
        int[] coins=new int[n];
        for (int i = 0; i <n ; i++) {
            coins[i]=0;
        }
        for (int i = 0; i < n; i++) {//第i次翻
            for (int j = 0; j <n ; j++) {//第j个不翻
                if (j!=i){
                    coins[j]=1-coins[j];
                }
            }
            for (int j = 0; j <n ; j++) {
                System.out.print(coins[j]);
            }
            System.out.println();
        }
    }
}
