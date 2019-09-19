package luogu;

import java.util.Scanner;

/**
 * @ClassName RockPaperScissors
 * @Description  P1328 生活大爆炸版石头剪刀布
 * 现在,小 A和小 B尝试玩这种升级版的猜拳游戏。已知他们的出拳都是有周期性规律的，但周期长度不一定相等。
 * 例如：如果小A以“石头-布-石头-剪刀-蜥蜴人-斯波克”长度为 66 的周期出拳,
 * 那么他的出拳序列就是“石头-布-石头-剪刀-蜥蜴人-斯波克-石头-布-石头-剪刀-蜥蜴人-斯波克-......”,
 * 而如果小B以“剪刀-石头-布-斯波克-蜥蜴人”长度为 55 的周期出拳,
 * 那么他出拳的序列就是“剪刀-石头-布-斯波克-蜥蜴人-剪刀-石头-布-斯波克-蜥蜴人-......”
 *
 * 已知小 A和小 B 一共进行 NN 次猜拳。每一次赢的人得 11 分，输的得 00 分；
 * 平局两人都得 00 分。现请你统计 NN 次猜拳结束之后两人的得分。
 * @Author NebulaPort
 * @Date 2019/9/18 9:31
 */
public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        int na=in.nextInt();
        int nb=in.nextInt();
        in.nextLine();
        int[] a=new int[na];
        int[] b=new int[nb];
        for (int i = 0; i <na ; i++) {
            a[i]=in.nextInt();
        }
        in.nextLine();
        for (int i = 0; i <nb ; i++) {
            b[i]=in.nextInt();
        }
        int[][]score={{0,0,1,1,0},{1,0,0,1,0},{0,1,0,0,1},{0,0,1,0,1},{1,1,0,0,0}};
        int sa=0,sb=0;
        //na和nb的最小公倍数
        int lcm=na*nb/gcd(na,nb);
        for (int i = 0; i <lcm ; i++) {
            sa+=score[a[i%na]][b[i%nb]];
            sb+=score[b[i%nb]][a[i%na]];
        }
        sa=sa*(n/lcm);
        sb=sb*(n/lcm);
        for (int i = 0; i <n%lcm ; i++) {
            sa+=score[a[i%na]][b[i%nb]];
            sb+=score[b[i%nb]][a[i%na]];
        }
        System.out.println(sa+" "+sb);
    }
    //求最大公约数
    private static int gcd(int a, int b){
        if (b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}
