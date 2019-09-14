package luogu;

import java.util.Scanner;

/**
 * @ClassName SouvenirGrouping
 * @Description  P1094 纪念品分组
 * 元旦快到了，校学生会让乐乐负责新年晚会的纪念品发放工作。
 * 为使得参加晚会的同学所获得 的纪念品价值相对均衡，他要把购来的纪念品根据价格进行分组，
 * 但每组最多只能包括两件纪念品， 并且每组纪念品的价格之和不能超过一个给定的整数。
 * 为了保证在尽量短的时间内发完所有纪念品，乐乐希望分组的数目最少。
 *
 * 你的任务是写一个程序，找出所有分组方案中分组数最少的一种，输出最少的分组数目。
 * @Author NebulaPort
 * @Date 2019/9/13 16:47
 */
public class SouvenirGrouping {
    private static int[]tmpArr=new int[30005];
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int w=in.nextInt();
        in.nextLine();
        int n=in.nextInt();
        in.nextLine();
        int[] prices=new int[n];
        for (int i = 0; i <n ; i++) {
            prices[i]=in.nextInt();
            in.nextLine();
        }
        merge(prices,0,n-1);
        int cnt=0;
        int i=0,j=n-1;
        while (i<j){
            if (prices[i]+prices[j]>w){
                cnt++;
                j--;
            }else {
                cnt++;
                j--;i++;
            }
        }
        if (i==j){cnt++;}
        System.out.println(cnt);
    }
    private static void merge(int[]a,int l,int r){
        if (l==r){return;}
        int mid=(l+r)/2;
        merge(a,l,mid);
        merge(a,mid+1,r);

        int i = l, j = mid+1, k = l;
        while (i <= mid && j <= r) {
            if (a[i] <= a[j]) {
                tmpArr[k++] = a[i++];
                //先赋值再+1
            } else {
                tmpArr[k++] = a[j++];

            }
        }
        while (i <= mid) {
            tmpArr[k] = a[i];
            k++;i++;
        }
        while (j <= r) {
            tmpArr[k] = a[j];
            k++;j++;
        }

        for (i = l; i <= r; i++) {
            a[i] = tmpArr[i];
            //复制回a数组中
        }
    }
}
