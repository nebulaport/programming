import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @ClassName Test
 * @Description
 * @Author NebulaPort
 * @Date 2019/8/23 15:38
 */
public class Test {



    public static void main(String[] args) {
        int i=5;

        while(i-->0){
            System.out.print(i+",");
        }
        System.out.println();
        i=5;
        while (--i>0){
            System.out.print(i+",");
        }
        System.out.println();
        i=5;
        while (0<i--){
            System.out.print(i+",");
        }
        System.out.println();

    }
}
