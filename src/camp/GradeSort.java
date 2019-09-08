package camp;

import java.util.Scanner;

/**
 * @ClassName GradeSort
 * @Description
 * 有 n 名学生，它们的学号分别是 1,2,…,n。这些学生都选修了邓老师的算法训练营、数据结构训练营这两门课程。
 *
 * 学期结束了，所有学生的课程总评都已公布，所有总评分数都是 [0,100] 之间的整数。巧合的是，不存在两位同学，他们这两门课的成绩都完全相同。
 *
 * 邓老师希望将这些所有的学生按这两门课程的总分进行降序排序，特别地，如果两位同学的总分相同，那邓老师希望把算法训练营得分更高的同学排在前面。由于上面提到的巧合，所以，这样排名就可以保证没有并列的同学了。
 *
 * 邓老师将这个排序任务交给了他的助教。可是粗心的助教没有理解邓老师的要求，将所有学生按学号进行了排序。
 *
 * 邓老师希望知道，助教的排序结果中，存在多少逆序对。
 *
 * 如果对于两个学生 (i,j) 而言，i 被排在了 j 前面，并且i 本应被排在 j 的后面，我们就称 (i,j) 是一个逆序对。
 *
 * 请你先帮邓老师把所有学生按正确的顺序进行排名，再告诉他助教的错误排名中逆序对的数目。
 *
 * 输入格式
 * 第一行一个整数 n，表示学生的个数。
 *
 * 第 2 行到第 n+1 行，每行 2 个用空格隔开的非负整数，第 i+1 行的两个数依次表示学号为 i 的同学的算法训练营、数据结构训练营的总评成绩。
 *
 * 输出格式
 * 输出包含 n+1 行。
 *
 * 前 n 行表示正确的排序结果，每行 4 个用空格隔开的整数，第 i 行的数依次表示排名为 i 的同学的学号、总分、算法训练营成绩、数据结构训练营成绩。
 *
 * 第 n+1 行一个整数，表示助教的错误排名中逆序对的数目。

 * @Author NebulaPort
 * @Date 2019/8/21 20:48
 */
public class GradeSort {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n=in.nextInt();
        int[] no=new int[n];
        int[] a=new int[n];
        int[] ds=new int[n];
        int[] sum=new int[n];
        int count=0;
        in.nextLine();
        for (int i = 0; i < n; i++) {
            no[i]=i+1;
            a[i]=in.nextInt();
            ds[i]=in.nextInt();
            sum[i]=a[i]+ds[i];
            in.nextLine();
        }

        //冒泡排序，只交换了存学号的数组
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <n-i ; j++) {
                if (sum[no[j-1] - 1] < sum[no[j]-1]||
                        (sum[no[j-1] - 1]==sum[no[j]-1]&&a[no[j-1] - 1]<a[no[j]-1])) {
                    int temp=no[j-1];
                    no[j-1]=no[j];
                    no[j]=temp;
                    count++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(no[i]+" ");
            System.out.print(sum[no[i]-1]+" ");
            System.out.print(a[no[i]-1]+" ");
            System.out.print(ds[no[i]-1]);
            System.out.println();


        }
        System.out.println(count);

    }

}
