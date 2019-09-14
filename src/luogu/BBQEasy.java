package luogu;

import java.util.Scanner;

/**
 * @ClassName BBQEasy
 * @Description AT1979 BBQ Easy
 * 史努克在参加一个BBQ派对， 他要准备N组食物， 他有2N的食材， 需要两两组成一个食物，
 * 食物的价值是两食材中较小的那个。 问最大总价值是多少
 * @Author NebulaPort
 * @Date 2019/9/13 23:16
 */
public class BBQEasy {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        int[] value=new int[n*2];
        for (int i = 0; i <2*n ; i++) {
            value[i]=in.nextInt();

        }
        for (int i = 0; i <value.length; i++) {
            for (int j = 1; j <value.length-i ; j++) {
                if (value[j-1]>value[j]){
                    int tmp=value[j-1];
                    value[j-1]=value[j];
                    value[j]=tmp;
                }
            }
        }
        int sum=0;
        for (int i = 0; i <2*n ; i+=2) {
            sum+=value[i];
        }
        System.out.println(sum);
    }
}
