package luogu.dp;

import java.util.Scanner;

/**
 * @ClassName PassBall
 * @Description  P1057 传球游戏
 * @Author NebulaPort
 * @Date 2019/9/19 15:05
 */
public class PassBall {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        //设f[i][j]表示经过k次传到编号为i的人手中的方案数
        int[][]f=new int[n+1][m+1];
        f[1][0]=1;

            for (int j = 1; j <=m ; j++) {
                f[1][j]=f[n][j-1]+f[2][j-1];
                for (int i = 2; i <n ; i++) {
                    f[i][j]=f[i-1][j-1]+f[i+1][j-1];
                }
                f[n][j]=f[n-1][j-1]+f[1][j-1];
            }

        System.out.println(f[1][m]);
    }
}
