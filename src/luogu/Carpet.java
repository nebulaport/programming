package luogu;

import java.util.Scanner;

/**
 * @ClassName Carpet
 * @Description  P1003 铺地毯
 * 为了准备一个独特的颁奖典礼，组织者在会场的一片矩形区域（可看做是平面直角坐标系的第一象限）铺上一些矩形地毯。
 * 一共有 nn 张地毯，编号从 11 到nn。现在将这些地毯按照编号从小到大的顺序平行于坐标轴先后铺设，后铺的地毯覆盖在前面已经铺好的地毯之上。
 *
 * 地毯铺设完成后，组织者想知道覆盖地面某个点的最上面的那张地毯的编号。注意：在矩形地毯边界和四个顶点上的点也算被地毯覆盖。
 * @Author NebulaPort
 * @Date 2019/9/5 15:00
 */
public class Carpet {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        in.nextLine();
        int[]x=new int[N];
        int[]y=new int[N];
        int[]a=new int[N];
        int[]b=new int[N];
        for (int i = 0; i < N; i++) {
            x[i]=in.nextInt();
            y[i]=in.nextInt();
            a[i]=in.nextInt();
            b[i]=in.nextInt();
           in.nextLine();
        }
        int m=in.nextInt();
        int n=in.nextInt();
        int no=-1;

        for (int i = N-1; i>=0; i--) {
            if (x[i]<=m&&m<=x[i]+a[i]&&y[i]<=n&&n<=y[i]+b[i]){
                no=i+1;
                break;
            }
        }
        System.out.println(no);


    }
}
