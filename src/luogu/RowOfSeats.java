package luogu;

import java.util.Scanner;

/**
 * @ClassName RowOfSeats
 * @Description P1056 排座椅
 * 上课的时候总会有一些同学和前后左右的人交头接耳，这是令小学班主任十分头疼的一件事情。
 * 不过，班主任小雪发现了一些有趣的现象，当同学们的座次确定下来之后，只有有限的D对同学上课时会交头接耳。
 *
 * 同学们在教室中坐成了MM行NN列，坐在第i行第j列的同学的位置是(i,j)(i,j)，
 * 为了方便同学们进出，在教室中设置了KK条横向的通道，LL条纵向的通道。
 *
 * 于是，聪明的小雪想到了一个办法，或许可以减少上课时学生交头接耳的问题：她打算重新摆放桌椅，改变同学们桌椅间通道的位置，
 * 因为如果一条通道隔开了22个会交头接耳的同学，那么他们就不会交头接耳了。
 *
 * 请你帮忙给小雪编写一个程序，给出最好的通道划分方案。在该方案下，上课时交头接耳的学生的对数最少。
 * @Author NebulaPort
 * @Date 2019/9/17 22:12
 */
public class RowOfSeats {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int m=in .nextInt();
        int n=in.nextInt();
        int k=in.nextInt();
        int l=in.nextInt();
        int d=in.nextInt();

        int[]row=new int[m+1];
        int[]col=new int[n+1];
        for (int i = 0; i <d ; i++) {
            in.nextLine();
            int x=in.nextInt();
            int y=in.nextInt();
            int p=in.nextInt();
            int q=in.nextInt();
            if (x==p){
                col[Math.min(y,q)]++;
            }else {
                row[Math.min(x,p)]++;
            }
        }
        int[] ans1=new int[k];
        int[] ans2=new int[l];

        for (int i = 0; i <k ; i++) {
            int max=1;
            for (int j = 2; j <m ; j++) {
                if (row[j]>=row[max]){
                    max=j;
                }
            }
            ans1[i]=max;
            row[max]=0;
        }
        for (int i = 0; i <l ; i++) {
            int max=1;
            for (int j = 2; j <n ; j++) {
                if (col[j]>=col[max]){
                    max=j;
                }
            }
            ans2[i]=max;
            col[max]=0;
        }
        qSort(ans1,0,k-1);
        qSort(ans2,0,l-1);

        System.out.print(ans1[0]);
        for (int i = 1; i <k ; i++) {
            System.out.print(" "+ans1[i]);
        }
        System.out.println();
        System.out.print(ans2[0]);
        for (int i = 1; i <l ; i++) {
            System.out.print(" "+ans2[i]);
        }


    }

    private static void  qSort(int[]a,int left,int right){
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
