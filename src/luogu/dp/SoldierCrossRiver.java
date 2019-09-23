package luogu.dp;

import java.util.Scanner;

/**
 * @ClassName SoldierCrossRiver
 * @Description P1002 过河卒
 * 棋盘上AA点有一个过河卒，需要走到目标BB点。卒行走的规则：可以向下、或者向右。
 * 同时在棋盘上CC点有一个对方的马，该马所在的点和所有跳跃一步可达的点称为对方马的控制点。
 * 因此称之为“马拦过河卒”。
 *
 * 棋盘用坐标表示，AA点(0, 0)(0,0)、BB点(n, m)(n,m)(nn, mm为不超过2020的整数)，同样马的位置坐标是需要给出的。
 *
 * 现在要求你计算出卒从AA点能够到达BB点的路径的条数，假设马的位置是固定不动的，并不是卒走一步马走一步。
 * @Author NebulaPort
 * @Date 2019/9/5 11:19
 */
public class SoldierCrossRiver {
    public static void main(String[] args) {
        int x,y,hx,hy;

        Scanner in=new Scanner(System.in);
        x=in.nextInt();
        y=in.nextInt();
        hx=in.nextInt();
        hy=in.nextInt();
        x++;y++;hx++;hy++;
        long[][] dp=new long[x+1][y+1];

        dp[1][0]=1;

        for (int i = 1; i < x+1; i++) {
            for (int j = 1; j <y+1 ; j++) {
                boolean hasHorse =((i==hx-1&&(j==hy-2||j==hy+2))||(i==hx-2&&(j==hy-1||j==hy+1))
                        ||(i==hx+1&&(j==hy-2||j==hy+2))||(i==hx+2&&(j==hy-1||j==hy+1))||(i==hx&&j==hy));
                if (!hasHorse){
                    dp[i][j]=dp[i][j-1]+dp[i-1][j];
                }
            }
        }
        System.out.println(dp[x][y]);
    }
}
