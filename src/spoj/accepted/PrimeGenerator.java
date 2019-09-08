package spoj.accepted;

import java.util.Scanner;

/**
 * @ClassName PrimeGenerator
 * @Description Prime Generator
 * Input
 * The input begins with the number t of test cases in a single line (t<=10).
 * In each of the next t lines there are two numbers m and n (1 <= m <= n <= 1000000000, n-m<=100000) separated by a space.
 *
 * Output
 * For every test case print all prime numbers p such that m <= p <= n, one number per line, test cases separated by an empty line.
 * @Author NebulaPort
 * @Date 2019/8/22 10:15
 */
public class PrimeGenerator {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n=in.nextInt();
        int[] lo =new int[n];
        int[] hi =new int[n];

        for (int i = 0; i < n; i++) {
            lo[i]=in.nextInt();
            hi[i]=in.nextInt();
        }

        while(n-->0){
            for (; lo[lo.length-n-1] <= hi[hi.length-n-1]; lo[lo.length-n-1]++) {
                if (isPrime(lo[lo.length-n-1])){
                    System.out.println(lo[lo.length-n-1]);
                }
            }
            System.out.println();
     }
    }
    private static boolean isPrime(int n){
        if (n<=1){
            return false;
        }
        for (int i = 2; i <= (int)Math.sqrt((double)n); i++) {
            if (n%i==0){
                return false;
            }
        }
        return true;
    }
}
