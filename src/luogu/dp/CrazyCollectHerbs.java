package luogu.dp;

import java.util.Scanner;

/**
 * @ClassName CrazyCollectHerbs
 * @Description  P1616 疯狂的采药
 * @Author NebulaPort
 * @Date 2019/9/23 9:47
 */
public class CrazyCollectHerbs {
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
        for (int i = 1; i <=n ; i++) {
            for (int j = t[i]; j <=totalTime ; j++) {
                f[j]=Math.max(f[j],f[j-t[i]]+w[i]);
            }
        }
        System.out.println(f[totalTime]);
    }
}
