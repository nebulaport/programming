package luogu;

import java.math.BigInteger;
import java.util.Scanner;

import static java.math.BigInteger.*;

/**
 * @ClassName FactorialSum
 * @Description  P1009 阶乘之和
 * 用高精度计算出S=1!+2!+3!+…+n! (n≤50)S=1!+2!+3!+…+n!(n≤50)
 *
 * 其中“!”表示阶乘，例如：5!=5 \times 4 \times 3 \times 2 \times 15!=5×4×3×2×1。
 * @Author NebulaPort
 * @Date 2019/9/6 22:21
 */
public class FactorialSum {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();

        BigInteger sum= valueOf(0);
        BigInteger factorial= valueOf(1);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=i ; j++) {
                factorial=factorial.multiply(valueOf(j));
            }
            sum= sum.add( factorial);
            factorial= BigInteger.valueOf(1);
        }
        System.out.println(sum);
    }
}
