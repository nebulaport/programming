package luogu;

import java.util.Scanner;

/**
 * @ClassName PetersSmoke
 * @Description  P1150 Peter的烟
 * Peter 有n根烟，他每吸完一根烟就把烟蒂保存起来，
 * k(k>1)个烟蒂可以换一个新的烟，那么 Peter 最终能吸到多少根烟呢？
 * @Author NebulaPort
 * @Date 2019/10/12 16:02
 */
public class PetersSmoke {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        int ans=n;
        while (n>=k){
            ans+=n/k;
            n=n/k+n%k;
        }
        System.out.println(ans);
    }
}
