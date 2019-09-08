package luogu;

import java.util.Scanner;

/**
 * @ClassName TreeOutsideSchoole
 * @Description
 * @Author NebulaPort
 * @Date 2019/9/5 9:55
 */
public class TreeOutsideSchoole {
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
