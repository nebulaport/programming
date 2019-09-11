package luogu;

import java.util.Scanner;

/**
 * @ClassName PowerSquare
 * @Description  P1010 幂次方
 * 任何一个正整数都可以用2的幂次方表示。例如
 * 137=2^7+2^3+2^0
 * 137=27+23+20
 * 同时约定方次用括号来表示，即a^b可表示为a(b)。
 * 由此可知，137可表示为：
 * 2(7)+2(3)+2(0)
 * 进一步：7= 2^2+2+2^0$$ (2^1用2表示)，并且 $$3=2+2^0
 * 所以最后137137可表示为：2(2(2)+2+2(0))+2(2+2(0))+2(0)
 * 又如：
 * 1315=2^{10} +2^8 +2^5 +2+1
 * 1315=210+28+25+2+1
 * 所以1315最后可表示为：
 * 2(2(2+2(0))+2)+2(2(2+2(0)))+2(2(2)+2(0))+2+2(0)

 * @Author NebulaPort
 * @Date 2019/9/11 10:58
 */
public class PowerSquare {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        run(n);
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
