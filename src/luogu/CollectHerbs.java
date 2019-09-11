package luogu;

import java.util.Scanner;

/**
 * @ClassName CollectHerbs
 * @Description  P1048 采药
 * 第一行有2个整数T(1≤T≤1000)和M(1≤M≤100)，用一个空格隔开，T代表总共能够用来采药的时间，M代表山洞里的草药的数目。
 * 接下来的M行每行包括两个在1到100之间（包括1和100）的整数，分别表示采摘某株草药的时间和这株草药的价值。
 * @Author NebulaPort
 * @Date 2019/9/11 14:33
 */
public class CollectHerbs {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int totalTime=in.nextInt();
        int n=in.nextInt();
        in.nextLine();
        int[] t=new int[n+1];
        int[] w=new int[n+1];
        for (int i = 1; i <n+1 ; i++) {
            t[i]=in.nextInt();
            w[i]=in.nextInt();
            in.nextLine();
        }
        int[]f=new int[totalTime+1];
        for (int i = 1; i <= n; i++) {
            for (int j = totalTime; j >=t[i] ; j--) {
                f[j]=Math.max(f[j],f[j-t[i]]+w[i]);
            }
        }
        System.out.println(f[totalTime]);
    }
}
