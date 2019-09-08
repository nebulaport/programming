package luogu;

import java.util.Scanner;

/**
 * @ClassName SingleplankBridge
 * @Description  P1007 独木桥
 * @Author NebulaPort
 * @Date 2019/9/6 15:03
 */
public class SingleplankBridge {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int L =in.nextInt();
        in.nextLine();
        int N =in.nextInt();
        in.nextLine();
        int[]a=new int[N];
        for (int i = 0; i <N ; i++) {
            a[i]=in.nextInt();
        }
       int min=0,max=0;
        for (int i = 0; i < N; i++) {
            min=Math.max(min,Math.min(a[i],L+1-a[i]));
            max=Math.max(max,Math.max(a[i],L+1-a[i]));
        }

        System.out.println(min+" "+max);
    }
}
