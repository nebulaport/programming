package luogu;

import java.util.Scanner;

/**
 * @ClassName Sin
 * @Description  P1888 三角函数
 * 输入一组勾股数a,b,c（a≠b≠c），用分数格式输出其较小锐角的正弦值。（要求约分。）
 * @Author NebulaPort
 * @Date 2019/9/7 15:21
 */
public class Sin {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
        int c=in.nextInt();
        if (a<=b&&a<=c){
            if (b<c){
                getSin(a,c);
            }else {
                getSin(a,b);
            }
        }else if(b<=a&&b<=c){
            if (a<c){
                getSin(b,c);
            }else {
                getSin(b,a);
            }
        }else {
            if (b<a){
                getSin(c,a);
            }else {
                getSin(c,b);
            }
        }

    }
    private static void getSin(int a,int c){
        for (int i = a; i >1 ; i--) {
            if (a%i==0&&c%i==0){
                a=a/i;
                c=c/i;
                System.out.println(a+"/"+c);
                return;
            }
        }
        System.out.println(a+"/"+c);
    }
}
