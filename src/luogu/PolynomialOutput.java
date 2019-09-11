package luogu;

import java.util.Scanner;

/**
 * @ClassName PolynomialOutput
 * @Description  P1067 多项式输出
 * 输入共有 2 行
 *
 * 第一行1 个整数，n，表示一元多项式的次数。
 *
 * 第二行有n+1个整数，其中第i个整数表示第n−i+1 次项的系数，每两个整数之间用空格隔开。
 *
 * 输出格式
 * 输出共 11 行，按题目所述格式输出多项式。
 * @Author NebulaPort
 * @Date 2019/9/11 17:24
 */
public class PolynomialOutput {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        int[]input=new int[n+1];
        for (int i = 0; i <=n ; i++) {
            input[i]=in.nextInt();
        }


        int i=0;
        while (input[i] == 0) {i++;}
        //第一个非零项
        if (input[i]==1){
            System.out.print("x^" + (n - i));
        }else if (input[i]==-1){
            System.out.print("-x^" + (n - i));
        }else {
            System.out.print(input[i] + "x^" + (n - i));
        }
        i++;
        for (; i<n-1 ; i++) {
            if (input[i]>0){
                if (input[i]==1){
                    System.out.print("+x^" + (n - i));
                }else {
                    System.out.print("+"+input[i] + "x^" + (n - i));
                }
            }
            if (input[i]<0){
                if (input[i]==-1){
                    System.out.print("-x^" + (n - i));
                }else {
                    System.out.print(input[i] + "x^" + (n - i));
                }
            }

        }
        if (input[n-1]>0){
            if (input[n-1]==1){
                System.out.print("+x");
            }else {
                System.out.print("+"+input[n-1] + "x");
            }
        }
        //x的一次项
        if (input[n-1]<0){
            if (input[n-1]==-1){
                System.out.print("-x");
            }else {
                System.out.print(input[n-1] + "x");
            }
        }
        //常数项
        if (input[n] > 0) {
            System.out.print("+" + input[n]);
        } else if (input[n] < 0){
            System.out.print(input[n]);
        }


    }
}
