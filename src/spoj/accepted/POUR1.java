package spoj.accepted;

import java.util.Scanner;

/**
 * @ClassName POUR1
 * @Description POUR1 - Pouring water
 *
Given two vessels, one of which can accommodate a litres of water and the other - b litres of water,
determine the number of steps required to obtain exactly c litres of water in one of the vessels.

At the beginning both vessels are empty. The following operations are counted as 'steps':

emptying a vessel,
filling a vessel,
pouring water from one vessel to the other, without spilling,
until one of the vessels is either full or empty.


Input
An integer t, 1<=t<=100, denoting the number of testcases, followed by t sets of input data,
each consisting of three positive integers a, b, c, not larger than 40000, given in separate lines.

Output
For each set of input data, output the minimum number of steps required to obtain c litres,
or -1 if this is impossible.
 * @Author NebulaPort
 * @Date 2019/8/28 17:17
 */
public class POUR1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();

        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(in.nextLine());
            b[i] = Integer.parseInt(in.nextLine());
            c[i] = Integer.parseInt(in.nextLine());
        }
        for (int i = 0; i < n; i++) {
            System.out.println(minTimes(a[i],b[i],c[i]));
        }


    }
    private static int minTimes(int A, int B, int C){

        if (A<C&&B<C){
            return -1;
        }
        //Ax+By=C有解，则需要gcd(A,B)能整除C
        if (C%gcd(A,B)!=0){
            return -1;
        }

        int a = 0, b = 0;
        int cnt1 = 0, cnt2 = 0;
        //fill a (x>0, y<0)
        while (a!=C&&b!=C){
            if (a==0){
                a=A;
            }else if (b==B){
                b=0;
            }else{
                if (a-(B-b)>0){
                    a=a-B+b;
                    b=B;
                }else {
                    b=a+b;
                    a=0;
                }
            }
            cnt1++;
        }

        a=0;
        b=0;
        //fill b (x<0, y>0)
        while (a!=C&&b!=C){
            if (b==0){
                b=B;
            }else if (a==A){
                a=0;
            }else{
                if (b-(A-a)>0){
                    b=b-A+a;
                    a=A;
                }else {
                    a=a+b;
                    b=0;
                }
            }
            cnt2++;
        }
        return Math.min(cnt1,cnt2);
    }
    //求最大公约数
    private static int gcd(int a, int b){
        if (b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}
