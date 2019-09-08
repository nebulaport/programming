package camp;

import java.util.Scanner;

/**
 * @ClassName DigitalTriangle
 * @Description 数字三角形
 * 问题描述
 * 给定一个高度为 n 的“数字三角形”，其中第 i 行（1<=i<=n）有 i 个数。（例子如下图所示）
 * 1
 * 2 3
 * 4 5 6
 * 7 8 9 10
 *
 * 初始时，你站在“数字三角形”的顶部，即第一行的唯一一个数上。
 * 每次移动，你可以选择移动到当前位置正下方或者当前位置右下方的位置上。
 * 即如果你在 (i,j)（表示你在第i行从左往右数第j个数上，下同），你可以选择移动到 (i+1,j) 或 (i+1,j+1)。
 * 你想让你经过的所有位置（包括起点和终点）的数字总和最大。求这个最大值。
 *
 * 输入格式
 * 第一行一个正整数 n，表示数字三角形的大小。
 * 第 2 行到第 n+1 行，第 i+1 行为 i 个用空格隔开的非负整数，描述数字三角形的第 i 行。
 * 输出格式
 * 一行一个整数，表示经过路径上数的最大总和。
 *
 * @Author NebulaPort
 * @Date 2019/8/30 16:03
 */
public class DigitalTriangle {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();

        //dp:到(i,j)的路径的最大数字总和
        int[][] dp=new int[n+1][n+1];
        //a:(i,j)上的数字
        int[][] a=new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                a[i][j]=in.nextInt();
            }
            in.nextLine();
        }

        dp[1][1]=a[1][1];
        for (int i=2; i<=n; ++i) {
            for (int j=1; j<=i; ++j) {
                dp[i][j]=Math.max(dp[i-1][j-1],dp[i-1][j])+a[i][j];
            }
        }
        int ans=0;
        for (int i = 1; i <=n ; i++) {
            ans=Math.max(ans,dp[n][i]);
        }
        System.out.println(ans);
    }
}
