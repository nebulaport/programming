package spoj.accepted;

import java.util.Scanner;

/**
 * @ClassName FavoriteDice
 * @Description
 *
BuggyD loves to carry his favorite die around. Perhaps you wonder why it's his favorite?
Well, his die is magical and can be transformed into an N-sided unbiased die with the push of a button.
Now BuggyD wants to learn more about his die, so he raises a question:

What is the expected number of throws of his die while it has N sides so that each number is rolled at least once?

Input
The first line of the input contains an integer t, the number of test cases. t test cases follow.

Each test case consists of a single line containing a single integer N (1 <= N <= 1000) - the number of sides on BuggyD's die.

Output
For each test case, print one line containing the expected number of times BuggyD needs to throw his N-sided die so that each number appears at least once. The expected number must be accurate to 2 decimal digits.
 * @Author NebulaPort
 * @Date 2019/8/27 15:59
 */
public class FavoriteDice {
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
            java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00");

            System.out.println(df.format(expectedNumber(num)));
        }

    }
    private static double expectedNumber(int n){
        double e=0;
        for (double i = 0; i < n; i++) {
            e = e + n / (n - i);

        }
        return e;
    }
}
