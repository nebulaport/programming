package luogu;

import java.util.Scanner;

/**
 * @ClassName KthMin
 * @Description  P1138 第k小整数
 * 现有nn个正整数，n≤10000n≤10000，要求出这nn个正整数中的第kk个最小整数（相同大小的整数只计算一次），
 * k≤1000k≤1000，正整数均小于3000030000。
 * @Author NebulaPort
 * @Date 2019/9/15 23:13
 */
public class KthMin {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        in.nextLine();
        int[]nums=new int[n];
        for (int i = 0; i <n ; i++) {
            nums[i]=in.nextInt();
        }
        //quickSort(nums,0,n-1);
        qSort(nums,0,nums.length-1);
        int[]a=new int[k];
        int i=0,j=0;
        a[0]=nums[0];
        while (++j<n&&i<k-1){
            if (a[i]!=nums[j]) {
                a[++i]=nums[j];
            }
        }
        if (i<k-1){
            System.out.println("NO RESULT");
        }else {
            System.out.println(a[k-1]);
        }

    }

    private static void   qSort(int[]a,int left,int right){
        if (right - left < 1) {return;}
        if (right-left==1){
            if (a[right]<a[left]){swap(a,left,right);return;}
        }

        int mid = (right+left)/2;

        int pivot=a[mid];
        swap(a,left,mid);
        int i = left;
        int j = right;
        while (i < j) {
            while (i<j&&pivot <= a[j]) {
                j--;
            }
            while (i<j&&a[i] <= pivot) {
                i++;
            }

            if (i < j) {
                swap(a, i, j);
            }

        }
            swap(a, j, left);
            qSort(a, left, j - 1);
            qSort(a, j + 1, right);


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
