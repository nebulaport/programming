package spoj.accepted;

import java.util.Scanner;

/**
 * @ClassName Factorial
 * @Description
 *  For any positive integer N, Z(N) is the number of zeros at the end of the decimal form of number N!.
 * Input
 * There is a single positive integer T on the first line of input (equal to about 100000).
 * It stands for the number of numbers to follow.
 * Then there are T lines, each containing exactly one positive integer number N, 1 <= N <= 1000000000.
 *
 * Output
 * For every number N, output a single line containing the single non-negative integer Z(N).
 *
 * @Author NebulaPort
 * @Date 2019/8/27 14:18
 */
public class Factorial {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n=in.nextInt();
        int[] nums =new int[n];
        in.nextLine();
        for (int i = 0; i < n; i++) {
            nums[i]=in.nextInt();
            in.nextLine();
        }

        for (int num:nums) {
            System.out.println(zeros(num));
        }

    }
    private static int zeros(int n){
        int five=0;
        int two=0;
        int tmp=n;
        n=n/5;
        while (n>0){
            five+=n;
            n=n/5;
        }
        n=tmp;
        n=n/2;
        while(n>0){
            two+=n;
            n=n/2;
        }
        return Math.min(five,two);

    }
}
