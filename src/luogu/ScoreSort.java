package luogu;

import java.util.Scanner;

/**
 * @ClassName ScoreSort
 * @Description  P1093 奖学金
 * 某小学最近得到了一笔赞助，打算拿出其中一部分为学习成绩优秀的前5名学生发奖学金。 期末，每个学生都有3门课的成绩:语文、数学、英语。
 * 先按总分从高到低排序，如果两个同学总分相同，再按语文成绩从高到低排序，如果两个同学总分和语文成绩都相同，那么规定学号小的同学 排在前面，
 * 这样，每个学生的排序是唯一确定的。
 *
 * 任务：先根据输入的3门课的成绩计算总分，然后按上述规则排序，最后按排名顺序输出前五名名学生的学号和总分。
 * 注意，在前5名同学中，每个人的奖学金都不相同，因此，你必须严格按上述规则排序。例如，在某个正确答案中，如果前两行的输出数据(每行输出两个数:学号、总分) 是:
 *
 * 7 279
 * 5 279
 *
 * 这两行数据的含义是:总分最高的两个同学的学号依次是7号、5号。
 * 这两名同学的总分都是 279 (总分等于输入的语文、数学、英语三科成绩之和) ，但学号为7的学生语文成绩更高一些。如果你的前两名的输出数据是:
 *
 * 5 279
 * 7 279
 *
 * 则按输出错误处理，不能得分。
 * @Author NebulaPort
 * @Date 2019/9/13 16:30
 */
public class ScoreSort {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        int[] total=new int[n];
        int[] chinese=new int[n];
        int[] math=new int[n];
        int[] english=new int[n];
        int[] no=new int[n];
        for (int i = 0; i <n ; i++) {
            chinese[i]=in.nextInt();
            math[i]=in.nextInt();
            english[i]=in.nextInt();
            in.nextLine();
            total[i]=chinese[i]+math[i]+english[i];
            no[i]=i+1;
        }
        //按总分排
        for (int i = 0; i <n-1 ; i++) {
            for (int j = 1; j <n-i ; j++) {
                if (total[j-1]<total[j]){
                    swap(total,j-1,j);
                    swap(no,j-1,j);
                }
            }
        }
        //总分相同按语文成绩排
        for (int i = 0; i <n-1 ; i++) {
            for (int j = 1; j <n-i ; j++) {
                if (total[j-1]==total[j]&&chinese[no[j-1]-1]<chinese[no[j]-1]){
                    swap(total,j-1,j);
                    swap(no,j-1,j);
                }
            }
        }
        //总分语文相同按学号排
        for (int i = 0; i <n-1 ; i++) {
            for (int j = 1; j <n-i ; j++) {
                if (total[j-1]==total[j]&&chinese[no[j-1]-1]==chinese[no[j]-1]&&no[j-1]>no[j]){
                    swap(total,j-1,j);
                    swap(no,j-1,j);
                }
            }
        }
        for (int i = 0; i <5 ; i++) {
            System.out.println(no[i]+" "+total[i]);
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
