package luogu;

import java.util.Scanner;

/**
 * @ClassName Scholarship
 * @Description  P1051 谁拿了最多奖学金
 * 某校的惯例是在每学期的期末考试之后发放奖学金。发放的奖学金共有五种，获取的条件各自不同：
 *
 * 院士奖学金，每人80008000元，期末平均成绩高于8080分（>80>80），并且在本学期内发表11篇或11篇以上论文的学生均可获得；
 * 五四奖学金，每人40004000元，期末平均成绩高于8585分（>85>85），并且班级评议成绩高于8080分（>80>80）的学生均可获得；
 * 成绩优秀奖，每人20002000元，期末平均成绩高于9090分（>90>90）的学生均可获得；
 * 西部奖学金，每人10001000元，期末平均成绩高于8585分（>85>85）的西部省份学生均可获得；
 * 班级贡献奖，每人850850元，班级评议成绩高于8080分（>80>80）的学生干部均可获得；
 * 只要符合条件就可以得奖，每项奖学金的获奖人数没有限制，每名学生也可以同时获得多项奖学金。
 * 例如姚林的期末平均成绩是8787分，班级评议成绩8282分，同时他还是一位学生干部，那么他可以同时获得五四奖学金和班级贡献奖，奖金总数是48504850元。
 *
 * 现在给出若干学生的相关数据，请计算哪些同学获得的奖金总数最高（假设总有同学能满足获得奖学金的条件）。
 * @Author NebulaPort
 * @Date 2019/9/11 16:06
 */
public class Scholarship {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        String[] input=new String[n];

        for (int i = 0; i < n; i++) {
            input[i]=in.nextLine();
        }
        int total=0;
        int[]sum=new int[n];
        for (int i = 0; i <n ; i++) {

           String [] info=input[i].split(" ");

            if (Integer.parseInt(info[1])>80){
                if (Integer.parseInt(info[5])>0){sum[i]+=8000;total+=8000;}

            }
           if (Integer.parseInt(info[1])>85){
               if (Integer.parseInt(info[2])>80){sum[i]+=4000;total+=4000;}
               if ("Y".equals(info[4])){sum[i]+=1000;total+=1000;}
           }
            if (Integer.parseInt(info[1])>90){sum[i]+=2000;total+=2000;}
            if (Integer.parseInt(info[2])>80&&"Y".equals(info[3])){sum[i]+=850;total+=850;}
        }
        int max=0;
        for (int i = 1; i < n; i++) {
            if (sum[max]<sum[i]){
                max=i;
            }
        }
        String [] info=input[max].split(" ");
        System.out.println(info[0]);
        System.out.println(sum[max]);
        System.out.println(total);
    }
}
