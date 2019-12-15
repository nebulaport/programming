package camp;

import java.util.Scanner;

/**
 * @ClassName SubSequence
 * @Description  子序列
 * 求出输入字符串有多少不同的子序列，输出这个数对23333取模的结果
 * 字符串长度n<=500000
 * @Author NebulaPort
 * @Date 2019/12/15 14:32
 */
public class SubSequence {
    private static final int N=500005;
    private static final int MO=23333;
    /**
     * f[i]表示前i个字符形成的本质不同的子序列个数
     * p[i]表示字符s[i]最后出现的位置
     * last[i]表示字符i最后出现的位置，这里字符串只包含小写字母
     * p(i)=0时 f(i)=f(i-1)+f(i-1)+1
     * p(i)!=0时 f(i)=f(i-1)+f(i-1)-f(p(i)-1)
     * 答案是f(n),代码里字符串是从s[1]开始的，n=len-1
     * 解释懒得敲了，反正也不难理解
     * */
    static int[]f=new int[N];
    static int[]p=new int[N];
    static int[]last=new int[26];

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        char s[]=(0+in.nextLine()).toCharArray();
        int len=s.length;
        //计算p数组
        for (int i = 1; i <len ; i++) {
            int a=s[i]-'a';
            p[i]=last[a];
            last[a]=i;
        }
        //动态规划
        for (int i = 1; i <len ; i++) {
            if (p[i]!=0){
                f[i]=f[i-1]+f[i-1]-f[p[i]-1]+MO;
            }else{
                f[i]=f[i-1]+f[i-1]+1;
            }
            f[i]%=MO;
        }

        System.out.println(f[len-1]);
    }
}
