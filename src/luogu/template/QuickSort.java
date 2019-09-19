package luogu.template;

import java.util.Scanner;

/**
 * @ClassName QuickSort
 * @Description P1177 【模板】快速排序
 * RE StackOverflow
 * @Author NebulaPort
 * @Date 2019/9/15 13:26
 */
public class QuickSort {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        int[] a=new int[n];
        for (int i = 0; i <n ; i++) {
            a[i]=in.nextInt();
        }

        quickSort(a,0,a.length-1);
        //qSort(a,0,a.length-1);
        printArray(a);

    }
    /**
     * 快速排序
     * 三值取中作为pivot
     */
    private static void quickSort(int[] a, int left, int right) {

        if (right - left >= 10) {
            int pivot = Median3(a, left, right);
            int i = left;
            int j = right-1;
            while (i < j) {
                while (i < j&&a[i] <= pivot) {
                    i++;
                }
                while (i < j&&pivot <= a[j]) {
                    j--;
                }
                if (i < j) {
                    swap(a, i, j);
                }
            }
                swap(a, i, right - 1);
                quickSort(a, left, i - 1);
                quickSort(a, i + 1, right);

        }else {insertionSort(a,left,right);}
    }

    private static int Median3(int[]a, int left, int right)
    {
        //取数据的头、尾和中间三个数，并对他们进行排序
        //排序结果直接保存在数组中
        int centre = (left + right)/2;
        if(a[left] > a[centre]) {
            swap(a,left,centre);
        }
        if(a[left] > a[right]) {
            swap(a,left,right);
        }
        if(a[centre] > a[right]) {
            swap(a,centre,right);
        }
        //把中值，即pivot与数组倒数第二个元素交换
        swap(a,centre, right - 1);
        return a[right - 1];
        //返回pivot
    }
    private static int[] quickSort(int a[]){
        quickSort(a,0,a.length-1);
        return a;
    }

    /**
     * 插入排序
     * */
    private static void insertionSort(int[]a,int left,int right){
        for (int i = left+1; i <=right ; i++) {
            for (int j = i; j >0 ; j--) {
                if (a[j]<a[j-1]){
                    swap(a,j,j-1);
                }else{break;}
            }
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


    /**
     * 打印数组
     * */
    private static void printArray(int[] a){
        for (int anA : a) {
            System.out.print(anA + " ");
        }
        System.out.println();
    }



}
