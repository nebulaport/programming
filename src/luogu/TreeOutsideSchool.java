package luogu;

import java.util.Scanner;

/**
 * @ClassName TreeOutsideSchool
 * @Description P1047 校门外的树
 * 某校大门外长度为L的马路上有一排树，每两棵相邻的树之间的间隔都是1米。
 * 我们可以把马路看成一个数轴，马路的一端在数轴0的位置，另一端在L的位置；
 * 数轴上的每个整数点，即0,1,2,…,L0,1,2,…,L，都种有一棵树。
 *
 * 由于马路上有一些区域要用来建地铁。这些区域用它们在数轴上的起始点和终止点表示。
 * 已知任一区域的起始点和终止点的坐标都是整数，区域之间可能有重合的部分。现在要把这些区域中的树（包括区域端点处的两棵树）移走。
 * 你的任务是计算将这些树都移走后，马路上还有多少棵树。
 * @Author NebulaPort
 * @Date 2019/9/5 9:55
 */
public class TreeOutsideSchool {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int L=in.nextInt();
        int n=in.nextInt();
        in.nextLine();
        int[] a=new int[n];
        int[] b=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=in.nextInt();
            b[i]=in.nextInt();
        }
        boolean[] trees=new boolean[L+1];
        for (int i = 0; i <n ; i++) {
            for (int j=a[i];j<=b[i];j++) {
                trees[j]=true;
            }
        }
        int cnt=L+1;
        for (int i = 0; i <=L ; i++) {
            if (trees[i]){
             cnt--;
            }
        }
        System.out.println(cnt);

    }
}