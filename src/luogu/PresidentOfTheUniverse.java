package luogu;

import java.util.Scanner;

/**
 * @ClassName PresidentOfTheUniverse
 * @Description P1781 宇宙总统
 * 地球历公元6036年，全宇宙准备竞选一个最贤能的人当总统，共有n个非凡拔尖的人竞选总统，现在票数已经统计完毕，请你算出谁能够当上总统。
 * @Author NebulaPort
 * @Date 2019/10/12 16:16
 */
public class PresidentOfTheUniverse {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        String[] vote=new String[n];
        for (int i = 0; i <n ; i++) {
            vote[i]=in.nextLine();
        }
        int max=0;
        for (int i = 1; i <n ; i++) {
            if (isBigger(vote[i],vote[max])){
                max=i;
            }
        }
        System.out.println(max+1);
        System.out.println(vote[max]);
    }
    private static boolean isBigger(String str1,String str2){
        if (str1.length()!=str2.length()){
            return str1.length()>str2.length();
        }else{
            for (int i = 0; i <str1.length() ; i++) {
                if (str1.charAt(i)!=str2.charAt(i)){
                    return str1.charAt(i)>str2.charAt(i);
                }
            }
        }
        return false;
    }
}
