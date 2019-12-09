package luogu.rumen;

import java.util.Scanner;

/**
 * @ClassName P1909
 * @Description P1909 买铅笔
 * @Author NebulaPort
 * @Date 2019/12/9 22:26
 */
public class P1909 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[]nums=new int[3];
        int[]price=new int[3];
        for(int i=0;i<3;i++){
            in.nextLine();
            nums[i]=in.nextInt();
            price[i]=in.nextInt();
        }
        int a = n%nums[0]==0? (n/nums[0])*price[0]:(n/nums[0]+1)*price[0];
        int b = n%nums[1]==0? (n/nums[1])*price[1]:(n/nums[1]+1)*price[1];
        int c = n%nums[2]==0? (n/nums[2])*price[2]:(n/nums[2]+1)*price[2];
        System.out.println(Math.min(Math.min(a,b),c));

    }

}
