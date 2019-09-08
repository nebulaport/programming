package luogu;

import java.util.Scanner;

/**
 * @ClassName GraduationSeasonI
 * @Description P1372 又是毕业季I
 * 为了把毕业晚会办得更好，老师想要挑出默契程度最大的k个人参与毕业晚会彩排。
 * 可是如何挑呢？老师列出全班同学的号数1，2，……，n，并且相信k个人的默契程度便是他们的最大公约数（这不是迷信哦~）。
 * 这可难为了他，请你帮帮忙吧！
 *
 * PS：一个数的最大公约数即本身
 * @Author NebulaPort
 * @Date 2019/9/7 15:13
 */
public class GraduationSeasonI {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        while (n%k!=0){
            n--;
        }
        System.out.println(n/k);
    }
}
