package spoj.accepted;

import java.util.Scanner;

/**
 * @ClassName ADDREV
 * @Description ADDREV - Adding Reversed Numbers
 * Input
 * The input consists of N cases (equal to about 10000).
 * The first line of the input contains only positive integer N.
 * Then follow the cases.
 * Each case consists of exactly one line with two positive integers separated by space.
 * These are the reversed numbers you are to add.
 *
 * Output
 * For each case, print exactly one line containing only one integer - the reversed sum of two reversed numbers.
 * Omit any leading zeros in the output.
 * @Author NebulaPort
 * @Date 2019/8/28 16:53
 */
public class ADDREV {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        int[] a=new int[n];
        int[] b=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=in.nextInt();
            b[i]=in.nextInt();
            in.nextLine();
        }
        int sum;
        for (int i = 0; i < n; i++) {
            sum=reverse(a[i])+reverse(b[i]);
            System.out.println(reverse(sum));
        }
    }
    private static int reverse(int n){
        int result=0;
        while (n>0){
            result=n%10+result*10;
            n=n/10;
        }
        return result;
    }
}
