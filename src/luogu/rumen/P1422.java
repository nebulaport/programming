package luogu.rumen;

import java.util.Scanner;

/**
 * @ClassName P1422
 * @Description P1422 小玉家的电费
 * @Author NebulaPort
 * @Date 2019/12/9 22:25
 */
public class P1422 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        double cost=0;
        if(n<=150) {
            cost=n*0.4463;
        } else if(n<=400) {
            cost=150*0.4463+(n-150)*0.4663;
        } else {
            cost=150*0.4463+250*0.4663+(n-400)*0.5663;
        }

        System.out.println(String .format("%.1f",cost));

    }

}
