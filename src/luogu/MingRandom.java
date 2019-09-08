package luogu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName MingRandom
 * @Description P1059 明明的随机数
 * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，
 * 他先用计算机生成了NN个11到10001000之间的随机整数(N≤100)(N≤100)，
 * 对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。
 * 然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。
 * 请你协助明明完成“去重”与“排序”的工作。
 * @Author NebulaPort
 * @Date 2019/9/5 10:18
 */
public class MingRandom {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[] orig = new int[n];
        for (int i = 0; i < n; i++) {
            orig[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (orig[j - 1] > orig[j]) {
                    int tmp = orig[j - 1];
                    orig[j - 1] = orig[j];
                    orig[j] = tmp;
                }
            }

        }


        ArrayList<Integer> result = new ArrayList<Integer>();

        result.add(orig[0]);

        for (int i = 1; i < n; i++) {
            if (orig[i] != orig[i - 1]) {
                result.add(orig[i]);
            }
        }
        System.out.println(result.size());
        for (Integer aResult : result) {
            System.out.print(aResult + " ");
        }
    }
}
