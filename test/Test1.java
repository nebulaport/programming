import java.util.Scanner;

/**
 * @ClassName Test1
 * @Description
 * @Author NebulaPort
 * @Date 2019/9/15 14:54
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        int[] a=new int[n];
        for (int i = 0; i <n ; i++) {
            a[i]=in.nextInt();
        }
        for (int i = 0; i <n ; i++) {
            System.out.print(a[i]+" ");
        }


    }
}
