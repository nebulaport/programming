package luogu;

import java.util.Scanner;

/**
 * @ClassName SharingCards
 * @Description  P1031 均分纸牌
 * 有NN堆纸牌，编号分别为 1,2,…,N1,2,…,N。每堆上有若干张，但纸牌总数必为NN的倍数。可以在任一堆上取若干张纸牌，然后移动。
 *
 * 移牌规则为：在编号为11堆上取的纸牌，只能移到编号为22的堆上；
 * 在编号为NN的堆上取的纸牌，只能移到编号为N-1N−1的堆上；
 * 其他堆上取的纸牌，可以移到相邻左边或右边的堆上。
 *
 * 现在要求找出一种移动方法，用最少的移动次数使每堆上纸牌数都一样多。
 * @Author NebulaPort
 * @Date 2019/9/7 16:34
 */
public class SharingCards {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        int[]a=new int[n];
        int sum=0;
        for (int i = 0; i <n ; i++) {
            a[i]=in.nextInt();
            sum+=a[i];
        }
        int ans=0;
        for (int i = 0; i <n-1 ; i++) {
            if (a[i]>sum/n){
                ans++;
                a[i+1]+=a[i]-sum/n;
            }else if (a[i]<sum/n){
                ans++;
                a[i+1]-=sum/n-a[i];
            }
        }
        System.out.println(ans);

    }
}
