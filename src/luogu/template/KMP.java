package luogu.template;

import java.util.Scanner;

/**
 * @ClassName KMP
 * @Description  P3375 【模板】KMP字符串匹配
 * 70分，TLE
 * 嗯，又是Java的锅
 * @Author NebulaPort
 * @Date 2019/9/15 13:24
 */
public class KMP {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String source=in.nextLine();
        String pattern=in.nextLine();

        char[]src=source.toCharArray();
        char[]ptn=pattern.toCharArray();
        int[]next=new int[ptn.length+1];

        int k = -1;
        int j = 0;
        next[0] = -1;
        // next数组中next[0]为-1
        while (j < ptn.length ) {
            if (k == -1 || ptn[j] == ptn[k]) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        int i=0;
        j=0;
        while (i < src.length) {
            // 如果j = -1,或者当前字符匹配成功(src[i] = ptn[j]),都让i++,j++
            if (j == -1 || src[i] == ptn[j]) {
                i++;
                j++;
            } else {
                // 如果j!=-1且当前字符匹配失败,则令i不变,j=next[j],即让pattern模式串右移j-next[j]个单位
                j = next[j];
            }
            if (j == ptn.length){
                System.out.println(i-j+1);
                j = next[j];
            }
        }
        for (int l=1;l<next.length;l++) {
            System.out.print(next[l]+" ");
        }


    }

}
