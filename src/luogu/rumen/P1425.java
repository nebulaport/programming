package luogu.rumen;

import java.util.Scanner;

/**
 * @ClassName P1425
 * @Description P1425 小鱼的游泳时间
 * @Author NebulaPort
 * @Date 2019/12/9 22:24
 */
public class P1425 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
        int c=in.nextInt();
        int d=in.nextInt();
        int f=d-b;
        int borrow=0;
        if(f<0){
            borrow=-1;
            f+=60;
        }
        int e=c-a+borrow;
        System.out.println(e+" "+f);

    }

}
