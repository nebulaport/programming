package luogu.todo;

import java.util.Scanner;

/**
 * @ClassName TypingExercise
 * @Description TODO T99368 打字练习
 * 输入格式
 * R 君会依次告诉你网站的范文，他的输入和花费的时间。
 *
 * 其中范文和输入将会这样读入：给定若干行字符串，以单独的一行 EOF 结束，其中 EOF 不算入输入的文本。
 *
 * 最后一行一个整数 TT，表示他打字花费了 TT 秒。
 *
 * 可以参考样例输入输出文件和样例解释辅助理解。
 *
 * 输出格式
 * 一行一个整数，表示 KPM。
 * @Author NebulaPort
 * @Date 2019/10/13 10:08
 */
public class TypingExercise {
    private static String[] input=new String[10005];
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int i=0;
        while (i==0||!"EOF".equals(input[i-1])){
            input[i++]=in.nextLine();
        }
        String[] type=new String[--i];
        while (--i>=0){
            type[type.length-i-1]=in.nextLine();
        }
        in.nextLine();
        int t=in.nextInt();
        int ans=0;
        for (int j = 0; j <type.length ; j++) {
            for (int k = 0,l=0; k <input[j].length() ; k++,l++) {
                while(k+1<type[j].length()&&type[j].charAt(k+1)=='<'){
                    k=k+2;
                    while (k<type[j].length()&&type[j].charAt(k)=='<'){
                        k++;
                    }
                }
                if (k<type[j].length()&&l<input[j].length()&&type[j].charAt(k)==input[j].charAt(l)){
                    ans++;
                }
            }
        }
        System.out.println(ans/(t/60));

    }
}
