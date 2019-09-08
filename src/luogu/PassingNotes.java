package luogu;

import java.util.Scanner;

/**
 * @ClassName PassingNotes
 * @Description  P1006 传纸条
 * @Author NebulaPort
 * @Date 2019/9/6 16:41
 */
public class PassingNotes {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int m=in.nextInt();
        int n=in.nextInt();
        in.nextLine();
        int a[][]=new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n ; j++) {
                a[i][j]=in.nextInt();
            }
            in.nextLine();
        }

        int[][][][]dp=new int[m+1][n+1][m+1][n+1];
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                for (int k = 1; k <=m ; k++) {
                    int l=i+j-k;

                    if (l>0&&l<=n){
                        if (!(i==k&&j==l)){
                            dp[i][j][k][l]=Math.max
                                    (Math.max(dp[i-1][j][k-1][l], dp[i-1][j][k][l-1]),Math.max( dp[i][j-1][k-1][l], dp[i][j-1][k][l-1]))
                                    +a[i][j]+a[k][l];
                        }

                    }
                }
            }
        }
        System.out.println(dp[m][n-1][m-1][n]);
    }
}
