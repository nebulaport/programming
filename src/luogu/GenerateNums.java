package luogu;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @ClassName GenerateNums
 * @Description  P1037 产生数
 * 给出一个整数n(n<10^{30})和kk个变换规则(k≤15)。
 * 规则：
 * 一位数可变换成另一个一位数：
 * 规则的右部不能为零。
 * 问题：
 * 给出一个整数 nn 和kk 个规则。
 * 求出：
 * 经过任意次的变换（00次或多次），能产生出多少个不同整数。
 * 仅要求输出个数。
 * @Author NebulaPort
 * @Date 2019/9/18 10:59
 */
public class GenerateNums {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        int idx=str.indexOf(' ');
        int k=Integer.parseInt(str.substring(idx+1));
        str=str.substring(0,idx);
        boolean[][] vis=new boolean[10][10];
        for (int i = 0; i <k ; i++) {
            vis[in.nextInt()][in.nextInt()]=true;
            in.nextLine();
        }
        //floyd算法
        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j <10 ; j++) {
                for (int l = 0; l <10 ; l++) {
                    if (vis[j][i]&&vis[i][l]){
                        vis[j][l]=true;
                    }
                }
            }
        }
        for (int i = 0; i <10 ; i++) {
            vis[i][i]=true;
        }
        //每个数可以变换的种类
        int []a=new int[10];
        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j <10 ; j++) {
                if (vis[i][j]){
                    a[i]++;
                }

            }
        }
        //每个数可以变换的种类数目相乘就是总数目
        BigInteger ans=new BigInteger(String.valueOf(1));
        for (int i = 0; i <str.length(); i++) {
            int n=str.charAt(i)-48;
            ans=ans.multiply(BigInteger.valueOf(a[n]));
        }
        System.out.println(ans);

    }
}
