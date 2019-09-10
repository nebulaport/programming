package luogu;

import java.util.Scanner;

/**
 * @ClassName Stack
 * @Description  P1044 栈
 * 宁宁考虑的是这样一个问题：一个操作数序列，1,2,...,n1,2,...,n（图示为1到3的情况），栈A的深度大于n。
 *
 * 现在可以进行两种操作，
 *
 * 将一个数，从操作数序列的头端移到栈的头端（对应数据结构栈的push操作）
 * 将一个数，从栈的头端移到输出序列的尾端（对应数据结构栈的pop操作）
 *
 * 使用这两种操作，由一个操作数序列就可以得到一系列的输出序列，下图所示为由1 2 3生成序列2 3 1的过程。
 * 你的程序将对给定的n，计算并输出由操作数序列1,2,…,n1,2,…,n经过操作可能得到的输出序列的总数。
 * @Author NebulaPort
 * @Date 2019/9/10 12:58
 */
public class Stack {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        int[] f=new int[n+1];
        f[0]=1;
        f[1]=1;
        //卡特兰数
        for (int i = 2; i <=n ; i++) {
            for (int j = 0; j <i ; j++) {
                f[i] += f[j] * f[i-j-1];
            }
        }
        System.out.println(f[n]);


    }
   
}
