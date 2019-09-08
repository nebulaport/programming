package luogu;

import java.util.Scanner;

/**
 * @ClassName PrimeFactor
 * @Description P1075 质因数分解
 * @Author NebulaPort
 * @Date 2019/9/5 10:57
 */
public class PrimeFactor {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for (int i = 2; i < n; i++) {
            if (n%i==0&&isPrime(i)&&isPrime(n/i)){
                System.out.println(n/i);
                break;
            }
        }
    }
    private static boolean isPrime(int n){
        if (n<2){
            return false;
        }
        for (int i = 2; i <=Math.sqrt(n) ; i++) {
            if (n%i==0){
                return false;
            }
        }
        return true;

    }
}
