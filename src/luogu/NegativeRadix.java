package luogu;

import java.util.Scanner;

/**
 * @ClassName NegativeRadix
 * @Description  P1017 进制转换
 * @Author NebulaPort
 * @Date 2019/9/10 13:57
 */
public class NegativeRadix {
    private static StringBuffer sb=new StringBuffer();
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int r=in.nextInt();
        conversion(n,r);
        System.out.print(n+"=");
        System.out.print(sb.reverse().toString());
        System.out.print("(base"+r+")");
    }
    private static void conversion(int n,int r){
        if (n==0){return;}
        int m=n%r;
        if (m<0){
            //余数=余数-除数
            m-=r;
            //商+1
            n+=r;
        }
        char c;
        if(m>=10) {
            c= (char)('A'+m-10);
        }else{
            c= (char)('0'+m);
        }
        sb.append(c);
        conversion(n/r,r);
    }
}
