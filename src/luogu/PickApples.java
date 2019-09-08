package luogu;

import java.util.Scanner;

/**
 * @ClassName PickApples
 * @Description P1046 陶陶摘苹果
 * @Author NebulaPort
 * @Date 2019/9/5 9:32
 */
public class PickApples {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int[] apples=new int[10];
        for (int i = 0; i <10 ; i++) {
            apples[i]=in.nextInt();
        }
        in.nextLine();
        int h=in.nextInt()+30;
        int cnt=0;
        for(int apple:apples){
            if (apple<=h){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
