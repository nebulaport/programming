package luogu;

import java.util.Scanner;

/**
 * @ClassName SpliceNums
 * @Description  P1012 拼数
 * 设有nn个正整数(n≤20)(n≤20)，将它们联接成一排，组成一个最大的多位整数。
 *
 * 例如：n=3n=3时，33个整数1313,312312,343343联接成的最大整数为：3433121334331213
 *
 * 又如：n=4n=4时，44个整数77,1313,44,246246联接成的最大整数为：74246137424613
 * @Author NebulaPort
 * @Date 2019/9/7 11:04
 */
public class SpliceNums {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        String[] nums=new String[n];
        for (int i = 0; i <n ; i++) {
            nums[i]= String.valueOf(in.nextInt());
        }
        for (int i = 0; i <n-1 ; i++) {
            for (int j = i+1; j <n ; j++) {
                if ((nums[i]+nums[j]).compareTo(nums[j]+nums[i])<0){
                    String tmp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=tmp;
                }
            }
        }
        for (String num:nums){
            System.out.print(num);
        }
    }
}
