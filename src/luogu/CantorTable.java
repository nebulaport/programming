package luogu;

import java.util.Scanner;

/**
 * @ClassName CantorTable
 * @Description P1014 Cantor表
 * @Author NebulaPort
 * @Date 2019/9/7 14:01
 */
public class CantorTable {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();

        int i=1;
        while (i<n){
            n-=i;
            i++;
        }
        if (i%2==1){
            System.out.println(i+1-n+"/"+n);
        }else {
            System.out.println(n+"/"+(i+1-n));
        }

    }
}
