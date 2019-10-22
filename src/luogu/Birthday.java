package luogu;

import java.util.Scanner;

/**
 * @ClassName Birthday
 * @Description  P1104 生日
 * cjf君想调查学校OI组每个同学的生日，并按照从大到小的顺序排序。
 * 但cjf君最近作业很多，没有时间，所以请你帮她排序。
 * @Author NebulaPort
 * @Date 2019/10/22 22:07
 */
public class Birthday {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        String[] name=new String[n];
        int[] year=new int[n];
        int[] month=new int[n];
        int[] day=new int[n];
        for (int i = 0; i <n ; i++) {
            String[] input=in.nextLine().split(" ");
            name[i]=input[0];
            year[i]=Integer.parseInt(input[1]);
            month[i]=Integer.parseInt(input[2]);
            day[i]=Integer.parseInt(input[3]);
        }
        //no[]用来存编号，只排编号就行了
        int[] no=new int[n];
        for (int i = 0; i <n ; i++) {
            no[i]=i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n-i; j++) {
                if (year[no[j]]<year[no[j-1]]||
                        (year[no[j]]==year[no[j-1]]&&month[no[j]]<month[no[j-1]])||
                        (year[no[j]]==year[no[j-1]]&&month[no[j]]==month[no[j-1]]&&day[no[j]]<day[no[j-1]])||
                        (year[no[j]]==year[no[j-1]]&&month[no[j]]==month[no[j-1]]&&day[no[j]]==day[no[j-1]])&&no[j]>no[j-1]){
                    //注意：生日相同，靠后输入的排在前面
                    int tmp=no[j];
                    no[j]=no[j-1];
                    no[j-1]=tmp;
                }
            }
        }
        for (int i = 0; i <n ; i++) {
            System.out.println(name[no[i]]);
        }
    }
}
