package luogu;

import java.util.Scanner;

/**
 * @ClassName Station
 * @Description  P1011 车站
 * 火车从始发站（称为第1站）开出，在始发站上车的人数为a，然后到达第2站，
 * 在第2站有人上、下车，但上、下车的人数相同，因此在第2站开出时（即在到达第3站之前）车上的人数保持为a人。
 * 从第3站起（包括第3站）上、下车的人数有一定规律：
 * 上车的人数都是前两站上车人数之和，而下车人数等于上一站上车人数，一直到终点站的前一站（第n-1站），都满足此规律。
 * 现给出的条件是：共有N个车站，始发站上车的人数为a，最后一站下车的人数是m（全部下车）。
 * 试问x站开出时车上的人数是多少？
 * @Author NebulaPort
 * @Date 2019/9/7 22:26
 */
public class Station {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int a = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();

        //第n+1项车上剩余人数a和b的系数
        int[]fa=new int[n];
        int[]fb=new int[n];
        fa[0]=1;fa[1]=1;fa[2]=2;
        fb[0]=0;fb[1]=0;fb[2]=0;
        //求到第n-1站就可以了
        for (int i = 3; i <n-1 ; i++) {
            fa[i]=fa[i-1]+fa[i-2]-1;
            fb[i]=fb[i-1]+fb[i-2]+1;
        }
        int b=(m-fa[n-2]*a)/(fb[n-2]);
        System.out.println(fa[x-1]*a+fb[x-1]*b);
    }
}
