package luogu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName MingRandom
 * @Description
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
