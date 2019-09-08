package luogu;

import java.util.Scanner;

/**
 * @ClassName SelectNums
 * @Description  P1036 选数
 * 已知 nn 个整数 x_1,x_2,…,x_nx
 * 1,x2,…,xn，以及11个整数kk(k<nk<n)。
 * 从nn个整数中任选kk个整数相加，可分别得到一系列的和。
 * 例如当n=4,k=3n=4,k=3,44个整数分别为3,7,12,193,7,12,19时，可得全部的组合与它们的和为：
 *
 * 3+7+12=223+7+12=22
 *
 * 3+7+19=293+7+19=29
 *
 * 7+12+19=387+12+19=38
 *
 * 3+12+19=343+12+19=34。
 *
 * 现在，要求你计算出和为素数共有多少种。
 *
 * 例如上例，只有一种的和为素数：3+7+19=293+7+19=29。
 * @Author NebulaPort
 * @Date 2019/9/7 21:59
 */
public class SelectNums {
    private static int[] x=new int[20];

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            x[i]=in.nextInt();
        }
        System.out.println(selectNums(k,0,0, n -1));
    }
    private static boolean isPrime(int n){
        for (int i = 2; i <= Math.sqrt((double)n); i++) {
            if (n%i==0){
                return false;
            }
        }
        return true;
    }
    /**
     * cleftk为剩余的k，sumNow为前面累加的和，start和end为全组合剩下数字的选取范围；
     * 调用递归生成全组合，在过程中逐渐把K个数相加，当选取的数个数为0时，直接返回前面的累加和是否为质数即可
     * */
    private static int selectNums(int leftk,int sumNow,int start,int end){
        if (leftk == 0) {
            if (isPrime(sumNow)) {
                return 1;
            }
            return 0;
        }
        int sum=0;
        for (int i = start; i <=end ; i++) {
            sum+=selectNums(leftk-1,sumNow+x[i],i+1,end);
        }
        return sum;
    }
}
