package luogu.rumen;

import java.util.Scanner;

/**
 * @ClassName P1421
 * @Description P1421 小玉买文具
 * @Author NebulaPort
 * @Date 2019/12/9 22:23
 */
public class P1421 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
        int ans=(a*10+b)/19;
        System.out.println(ans);

    }
}
