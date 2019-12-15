package luogu.greedy;

import java.util.Scanner;

/**
 * @ClassName MixingMilk
 * @Description  P1208 [USACO1.3]混合牛奶 Mixing Milk
 * @Author NebulaPort
 * @Date 2019/12/11 10:48
 */
public class MixingMilk {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int cost = 0;
        //搞两个0就很过分了
        if (n!=0) {
            int m = in.nextInt();
            int[] p = new int[m];
            int[] a = new int[m];
            for (int i = 0; i < m; i++) {
                in.nextLine();
                p[i] = in.nextInt();
                a[i] = in.nextInt();
            }
            quickSort(p, a, 0, m - 1);

            int i = 0;
            while (n - a[i] > 0) {
                n -= a[i];
                cost += a[i] * p[i];
                i++;
            }
            cost += n * p[i];
        }

        System.out.println(cost);

    }
    private static void quickSort(int[]p,int[]a, int left,int right){
        if (right-left<1){return;}

        int mid=(left+right)/2;
        int pivot=p[mid];
        swap(p,left,mid);
        swap(a,left,mid);

        int i = left;
        int j = right;
        while (i < j) {
            while (i<j&&pivot <= p[j]) {
                j--;
            }
            while (i<j&&p[i] <= pivot) {
                i++;
            }
            if (i < j) {
                swap(p, i, j);
                swap(a, i, j);
            }
        }

        swap(p, j, left);
        swap(a, j, left);
        quickSort(p,a, left, j - 1);
        quickSort(p,a, j + 1, right);
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
