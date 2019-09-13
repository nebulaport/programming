package questions;

import java.util.Scanner;

/**
 * @ClassName MaxSubMatrix
 * @Description 子矩阵最大和
 * @Author NebulaPort
 * @Date 2019/9/12 15:23
 */
public class MaxSubMatrix {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[][] a = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = in.nextInt();
            }
        }
        int max=Integer.MIN_VALUE;
        int[]col=new int[n];

        max=Math.max(max,maxSubArray(col));
        for (int i = 0; i <n ; i++) {
            for (int j = n-1; j >=i ; j--) {
                for (int k = 0; k <n ; k++) {
                    col[k]+=a[j][k];
                }
                max=Math.max(max,maxSubArray(col));
            }

            for (int k = 0; k <n ; k++) {
                col[k]=0;
            }
        }
        System.out.println(max);
    }


    private static int maxSubArray(int[] nums) {
        int sum = 0, smax = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            smax = Math.max(smax, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return smax;
    }

}
