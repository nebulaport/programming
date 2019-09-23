package luogu.dp;

import java.util.Scanner;

/**
 * @ClassName PickMeal
 * @Description P1164 小A点菜
 * 不过uim由于买了一些辅（e）辅（ro）书，口袋里只剩MM元(M≤10000)。
 *
 * 餐馆虽低端，但是菜品种类不少，有NN种(N \le 100)(N≤100)，第ii种卖ai元(ai≤1000)。
 * 由于是很低端的餐馆，所以每种菜只有一份。
 *
 * 小A奉行“不把钱吃光不罢休”，所以他点单一定刚好吧uim身上所有钱花完。他想知道有多少种点菜方法。
 * @Author NebulaPort
 * @Date 2019/9/20 19:03
 */
public class PickMeal {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        in.nextLine();
        int[]a=new int[n];
        for (int i = 0; i <n ; i++) {
            a[i]=in.nextInt();
        }

        int[] f=new int[m+1];
        f[0]=1;
        for (int i = 0; i <n ; i++) {
            for (int j = m; j >=1 ; j--) {
                if (j>=a[i]) {
                    f[j]=f[j-a[i]]+f[j];
                }
            }
        }
        System.out.println(f[m]);
    }
}
