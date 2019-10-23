package luogu;

import java.util.Scanner;

/**
 * @ClassName LuckyWord
 * @Description P1125 笨小猴
 * 输入格式
 * 一个单词，其中只可能出现小写字母，并且长度小于100。
 * 输出格式
 * 共两行，第一行是一个字符串，假设输入的的单词是Lucky Word，那么输出“Lucky Word”，否则输出“No Answer”；
 * 第二行是一个整数，如果输入单词是Lucky Word，输出maxn-minn的值，否则输出00。
 * @Author NebulaPort
 * @Date 2019/10/23 9:58
 */
public class LuckyWord {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        char[] input=in.nextLine().toCharArray();
        //输入只有小写字母
        int[] times=new int[26];
        for (int i = 0; i <input.length; i++) {
            times[input[i]-97]++;
        }
        int max=times[0];
        for (int i = 1; i <26 ; i++) {
            if (times[i]>max){
                max=times[i];
            }
        }
        int min=max;
        for (int i = 0; i <26 ; i++) {
            if (times[i]>0&&times[i]<min){
                min=times[i];
            }
        }
        if (isPrime(max-min)){
            System.out.println("Lucky Word");
            System.out.println(max-min);
        }else{
            System.out.println("No Answer\n" +"0");
        }

    }

    private static boolean isPrime(int n){
        if (n<2){return false;}
        for (int i = 2; i <=Math.sqrt(n) ; i++) {
            if (n%i==0){return false;}
        }
        return true;
    }
}
