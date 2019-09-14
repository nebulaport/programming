package luogu;

import java.util.Scanner;

/**
 * @ClassName HightLowBitExchange
 * @Description  P1100 高低位交换
 * 给出一个小于2^{32}的正整数。这个数可以用一个32位的二进制数表示（不足32位用0补足）。
 *  我们称这个二进制数的前16位为“高位”，后16位为“低位”。
 *  将它的高低位交换，我们可以得到一个新的数。试问这个新的数是多少（用十进制表示）。
 * @Author NebulaPort
 * @Date 2019/9/13 22:56
 */
public class HightLowBitExchange {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        long n=in.nextLong();
        System.out.println((n>>16)|((n&0x0000ffff)<<16));
    }
}
