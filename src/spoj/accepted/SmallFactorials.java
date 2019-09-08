package spoj.accepted;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @ClassName SmallFactorials
 * @Description
You are asked to calculate factorials of some small positive integers.

Input
An integer t, 1<=t<=100, denoting the number of testcases, followed by t lines,
each containing a single integer n, 1<=n<=100.

Output
For each integer n given at input, display a line with the value of n!
 *
 * @Author NebulaPort
 * @Date 2019/8/27 14:58
 */
public class SmallFactorials {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=in.nextInt();
            in.nextLine();
        }
        for (int num:nums
             ) {
            System.out.println(getFactorial(num));
        }

    }
    private static BigInteger getFactorial(int n){
        BigInteger bi= BigInteger.valueOf(n);
        BigInteger fa= BigInteger.valueOf(1);

        while(bi.compareTo(BigInteger.valueOf(0))>0){
            fa=fa.multiply(bi);
            bi=bi.subtract(BigInteger.valueOf(1));
        }
        return fa;
    }

}
