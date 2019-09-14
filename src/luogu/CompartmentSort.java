package luogu;

import java.util.Scanner;

/**
 * @ClassName CompartmentSort
 * @Description  P1116 车厢重组
 * @Author NebulaPort
 * @Date 2019/9/13 14:06
 */
public class CompartmentSort {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        int []arr=new int[n];
        in.nextLine();
        for (int i = 0; i <n ; i++) {
            arr[i]=in.nextInt();
        }
        int ans=0;
        //冒泡排序交换数=逆序对数
        for (int i = 0; i <n ; i++) {
            for (int j = 1; j <n-i ; j++) {
                if (arr[j - 1] > arr[j]) {
                    int tmp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=tmp;
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
