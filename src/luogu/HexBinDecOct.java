package luogu;

import java.util.Scanner;

/**
 * @ClassName HexBinDecOct
 * @Description  P1143 进制转换
 * 题目描述
 * 请你编一程序实现两种不同进制之间的数据转换。
 *
 * 输入格式
 * 共三行，第一行是一个正整数，表示需要转换的数的进制n(2≤n≤16)n(2≤n≤16)，
 * 第二行是一个n进制数，若n>10n>10则用大写字母A-FA−F表示数码10-1510−15，
 * 并且该nn进制数对应的十进制的值不超过10000000001000000000，
 * 第三行也是一个正整数，表示转换之后的数的进制m(2≤m≤16)m(2≤m≤16)。
 *
 * 输出格式
 * 一个正整数，表示转换之后的mm进制数。
 * @Author NebulaPort
 * @Date 2019/10/27 14:59
 */
public class HexBinDecOct {
    static char chs[] = new char[36];
    static {
        for(int i = 0; i < 10 ; i++) {
            chs[i] = (char)('0' + i);
        }
        for(int i = 10; i < chs.length; i++) {
            chs[i] = (char)('A' + (i - 10));
        }
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int fromRadix=in.nextInt();
        in.nextLine();
        //转成十进制
        int n=Integer.parseInt(in.nextLine(),fromRadix);
        int toRadix=in.nextInt();

        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(chs[n%toRadix]);
            n = n / toRadix;
        }
        System.out.println(sb.reverse().toString());
    }
}
