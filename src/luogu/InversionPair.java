package luogu;

import java.util.Scanner;

/**
 * @ClassName InversionPair
 * @Description  P1908 逆序对
 * 求逆序对数
 * 这题的数据加强过，一半的用例TLE、MLE了，用c++应该能过
 * （我就当自己过了吧）
 * @Author NebulaPort
 * @Date 2019/9/13 13:22
 */
public class InversionPair {
    private static long ans=0;
    private static int[] tmpArr=new int[500005];
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        int []arr=new int[n];
        in.nextLine();
        for (int i = 0; i <n ; i++) {
            arr[i]=in.nextInt();
        }
       merge(arr,0,n-1);
        System.out.println(ans);
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
                ans += (long) mid - i + 1;
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

