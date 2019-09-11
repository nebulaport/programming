package luogu;

import java.util.Scanner;

/**
 * @ClassName ScoresDelineation
 * @Description  P1068 分数线划定
 * @Author NebulaPort
 * @Date 2019/9/11 18:05
 */
public class ScoresDelineation {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        in.nextLine();
        int[]no=new int[n];
        int[]score=new int[n];
        for (int i = 0; i <n ; i++) {
         no[i]=in.nextInt();
         score[i]=in.nextInt();
         in.nextLine();
        }
        for (int i = 0; i <score.length-1 ; i++) {
            int max = i;
            for (int j = i; j < score.length; j++) {
                if (score[j] > score[max]||(score[j]==score[max]&&no[j]<no[max])) {
                    max = j;
                }
            }
            swap(score,i,max);
            swap(no,i,max);
        }
        int cnt=0;
        m=m+m/2;
        while (score[m-1]==score[m]){
            m++;
        }
        System.out.println(score[m-1]+" "+m);
        for (int i = 0; i<m;i++) {
            System.out.println(no[i]+" "+score[i]);
        }


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
