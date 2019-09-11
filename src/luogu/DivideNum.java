package luogu;

import java.util.Scanner;

/**
 * @ClassName DivideNum
 * @Description  P1025 数的划分
 * @Author NebulaPort
 * @Date 2019/9/11 9:17
 */
public class DivideNum {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();

        int[][] f=new int[n+1][k+1];

        for (int i=1;i<=n;i++) {f[i][1]=1;f[i][0]=1;}for (int j=2;j<=k;j++) {f[1][j]=0;f[0][j]=0;}
        for (int i = 2; i <=n ; i++) {
            for (int j = 2; j <=k ; j++) {
                if (i>j) {
                    f[i][j]=f[i-1][j-1]+f[i-j][j];
                }else {
                    f[i][j]=f[i-1][j-1];
                }
            }

        }
        System.out.println(f[n][k]);
    }
}
