package luogu;

import java.util.Scanner;

/**
 * @ClassName ExerciseProblems
 * @Description  P1167 刷题
 * @Author NebulaPort
 * @Date 2019/9/18 9:45
 */
public class ExerciseProblems {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        int[] probs=new int[n];
        for (int i = 0; i <n ; i++) {
            probs[i]=in.nextInt();
            in.nextLine();
        }
        String start=in.nextLine();
        String end=in.nextLine();

        int[] days={31,28,31,30,31,30,31,31,30,31,30,31};
        int time=0;
        int sYear=Integer.parseInt(start.substring(0,4));
        int eYear=Integer.parseInt(end.substring(0,4));
        int sMouth=Integer.parseInt(start.substring(5,7));
        int eMouth=Integer.parseInt(end.substring(5,7));
        int sDay=Integer.parseInt(start.substring(8,10));
        int eDay=Integer.parseInt(end.substring(8,10));
        int sHour=Integer.parseInt(start.substring(11,13));
        int eHour=Integer.parseInt(end.substring(11,13));
        int sMin=Integer.parseInt(start.substring(14));
        int eMin=Integer.parseInt(end.substring(14));
        if (sYear<eYear){
            for (int i = sYear; i <eYear ; i++) {
                time+=365;
                if (isLeapYear(i)){
                    time++;
                }
            }
        }

        for (int i = 0; i <eMouth-1 ; i++) {
            time+=days[i];
        }
        if (isLeapYear(eYear)&&eMouth>2){time++;}
        for (int i = 0; i <sMouth-1 ; i++) {
            time-=days[i];
        }
        if (isLeapYear(sYear)&&sMouth>2){time--;}
        time+=eDay-sDay;
        time*=24*60;
        time+=(eHour-sHour)*60+(eMin-sMin);
        qSort(probs,0,n-1);
        int i=0;
        while (time>0&&i<n){
            if (time>=probs[i]){
                time-=probs[i];
                i++;
            }else {break;}
        }
        System.out.println(i);
    }
    /**
     * 判断是否为闰年
     * */
    private static boolean isLeapYear(int year){
        if (year%100==0){
            return year % 400 == 0;
        }
        return year % 4 == 0;
    }

    /**
     * 快排
     * */
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
