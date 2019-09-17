package luogu;

import java.util.Scanner;

/**
 * @ClassName APlusBBig
 * @Description  P1601 A+B Problem（高精）
 * 高精度加法,相当于a+b problem，不用考虑负数.
 * @Author NebulaPort
 * @Date 2019/9/17 14:18
 */
public class APlusBBig {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] num1 = in.nextLine().toCharArray();
        char[] num2 = in.nextLine().toCharArray();
        int p1=num1.length;
        int p2=num2.length;
        int flat=0;
        int len=Math.max(p1,p2);
        char[] ans=new char[len];
        if (p1>=p2) {
            ans=num1;
        }else {ans=num2;}
        while (--p1>=0&&--p2>=0){
            if (num1[p1]+num2[p2]+flat<106){
                ans[--len]= (char) (num1[p1]+num2[p2]-48+flat);
                flat=0;
            }else{
                ans[--len]= (char) ((num1[p1]+num2[p2]-96+flat)%10+48);
                flat=1;
            }
        }

        while (flat==1){
            if (len==0){
                System.out.print(1);
                break;
            }else {
                if (ans[len-1]<57) {
                    ans[--len]++;
                    flat=0;
                }else {
                    ans[--len]='0';
                }
            }
        }

        System.out.print(String.valueOf(ans));
    }
}
