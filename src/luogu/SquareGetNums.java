package luogu;

import java.util.Scanner;

/**
 * @ClassName SquareGetNums
 * @Description  P1004 方格取数
 * @Author NebulaPort
 * @Date 2019/9/6 15:57
 */
public class SquareGetNums {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        final int N=in.nextInt();
        int[][]a=new int[N+1][N+1];
        in.nextLine();
        while (true){

            int i=in.nextInt();
            int j=in.nextInt();
            a[i][j]=in.nextInt();
            in.nextLine();
            if (i==0&&j==0&&a[i][j]==0){
                break;
            }
        }
        int[][][][]dp=new int[N+1][N+1][N+1][N+1];

        for (int i = 1; i <=N ; i++) {
            for (int j = 1; j <=N ; j++) {
                for (int k = 1; k <=N ; k++) {
                    int l=i+j-k;
                    if (l>0&&l<=N){
                        dp[i][j][k][l]=Math.max
                                (Math.max(dp[i-1][j][k-1][l], dp[i-1][j][k][l-1]),Math.max( dp[i][j-1][k-1][l], dp[i][j-1][k][l-1]));
                        if (i==k&&j==l){
                            dp[i][j][k][l]+=a[i][j];
                        }else{
                            dp[i][j][k][l]+=a[i][j]+a[k][l];
                        }
                    }

                }
            }
        }
        System.out.println(dp[N][N][N][N]);
    }
}
