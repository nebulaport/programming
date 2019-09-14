package luogu;

import java.util.Scanner;

/**
 * @ClassName PickPeanuts
 * @Description  P1086 花生采摘
 * 你先找出花生最多的植株，去采摘它的花生；然后再找出剩下的植株里花生最多的，去采摘它的花生；依此类推，不过你一定要在我限定的时间内回到路边。
 * @Author NebulaPort
 * @Date 2019/9/13 14:47
 */
public class PickPeanuts {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int m=in.nextInt();
        int n=in.nextInt();
        int t=in.nextInt();
        in.nextLine();
        int[][] a=new int[m+1][n];
        int[]peanuts=new int[m*n];
        int[]x=new int[m*n];
        int[]y=new int[m*n];
        int k=-1;
        for (int i = 1; i <m+1 ; i++) {
            for (int j = 0; j <n ; j++) {
                a[i][j]=in.nextInt();
                if (a[i][j]>0){
                    peanuts[++k]=a[i][j];
                    x[k]=i;
                    y[k]=j;

                }
            }
            in.nextLine();
        }

        //选择排序
        for (int i = 0; i <k ; i++) {
            int max=i;
            for (int j = i; j <=k ; j++) {
                if (peanuts[max]<peanuts[j]){
                    max=j;
                }
            }
            swap(peanuts,max,i);
            swap(x,max,i);
            swap(y,max,i);
        }
        int ans=0;
        if ((x[0]*2+1)<=t){
            ans+=peanuts[0];
            t-=x[0]+1;
            int i=0;
            while (i<k&&(Math.abs(x[i]-x[i+1])+Math.abs(y[i]-y[i+1])+x[i+1])<t){
                ans+=peanuts[i+1];
                t-=Math.abs(x[i]-x[i+1])+Math.abs(y[i]-y[i+1])+1;
                i++;
            }
        }

        System.out.println(ans);
    }

    /**
     * 交换
     * */
    private static void swap(int[] nums, int i, int j) {
        int temp;

        if (nums != null) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }

}
