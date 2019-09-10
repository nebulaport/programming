package luogu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName Pingpong
 * @Description  P1042 乒乓球
 * 辣鸡题目,不说清楚输出规则
 * @Author NebulaPort
 * @Date 2019/9/10 10:16
 */
public class Pingpong {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList arrayList = new ArrayList();

        while (true) {
            arrayList.add(in.nextLine());
            if (String.valueOf(arrayList.get(arrayList.size() - 1)).contains("E")) {
                break;
            }
        }
        score(11, arrayList);
        System.out.println();
        score(21, arrayList);

    }

    private static void score(int n, ArrayList arrayList) {
        int W = 0, L = 0;
        for (Object anArrayList : arrayList) {
            String str = String.valueOf(anArrayList);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'W') {
                    W++;
                } else if (str.charAt(j) == 'L') {
                    L++;
                } else if (str.charAt(j) == 'E') {
                    System.out.println(W + ":" + L);
                    return;
                }
                if (Math.max(W, L) >= n && Math.abs(W - L) >= 2) {
                    System.out.println(W + ":" + L);
                    W = 0;
                    L = 0;
                }
            }

        }
    }

}
