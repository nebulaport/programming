package spoj.accepted;

import java.util.Scanner;

/**
 * @ClassName EASYPROB
 * @Description A Very Easy Problem!
 * Input
 * There's no input.
 *
 * Output
 * Output some form of these numbers: 137, 1315, 73, 136, 255, 1384, 16385,
 * one per line in the listed order.
 *
 * Example
 * The first two lines of the CORRECT output file are:
 *
 * 137=2(2(2)+2+2(0))+2(2+2(0))+2(0)
 * 1315=2(2(2+2(0))+2)+2(2(2+2(0)))+2(2(2)+2(0))+2+2(0)
 * The correct output file should contain 7 lines.
 * Question :EASYPROB - A Very Easy Problem!
 * The expansion is power.Eg 137= 2^(2^2 +2+ 2^0)+2^(2+2^0)+2^0
 * Eg.137 is 10001001
 * 1 Now, To find the first (leftmost) set bit ,
 * you can use k=log(num)/log(2).(gives you 7 as 7th bit is set)
 * 2 Then to remove that first set bit ,you substract num=num-2^k.
 * This gives you resultant number.(gives you 1001)
 * Now Repeat the above steps until num is 0
 * @Author NebulaPort
 * @Date 2019/8/28 16:42
 */
public class EASYPROB {
    public static void main(String[] args) {
        int[]test={137, 1315, 73, 136, 255, 1384, 16385};
        for (int aTest : test) {
            System.out.print(aTest + "=");
            run(aTest);
            System.out.println();
        }
    }

    private static void run(int n) {
        if(n==1) {return;}
        if(n==0) {System.out.print("0"); return; }

        for(int i=16, mask=0x00008000, first=1; i>=1; i--){
            if((mask&n)!=0){
                if(first==0) {
                    System.out.print("+");
                }
                System.out.print("2");
                //2^1时不需要括号
                if(i!=2) {
                    System.out.print("(");
                }
                //递归幂次
                run(i-1);
                //2^1时不需要括号
                if(i!=2) {
                    System.out.print(")");
                }
                if(first==1) {
                    first=0;
                }
            }
            mask>>=1;
        }
    }
}
