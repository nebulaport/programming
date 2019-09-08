package practise;
/**
* 2019/7/25
* java基础
* */

public class Exercise_1 {
    public static void main(String[] args) {
        System.out.println(sumPrimeNumbers(100));
        System.out.println(sumFactorial(10));
        System.out.println(sum2(3));
        System.out.println(sumFraction(3));
    }
/**
 *      1. 获取1-100之间的素数和
 * */
    public static int sumPrimeNumbers(int n){
        int sum=0;
        for (int i = 2; i <n ; i++) {
            boolean isPrime=true;
            for (int j = 2; j < i; j++) {
                //Math.sqrt((double)i)
                if (i%j==0){
                    isPrime=false;
                }
            }
            if (isPrime) {
                sum+=i;
            }
        }
        return sum;
    }

/**    	2. 获取1-10之间阶乘和*/
    public static int sumFactorial(int n){
        int sum=0;

        for (int i = 1; i <= n; i++) {
            int factorial=1;
            for (int j = 1; j <= i; j++) {
                factorial=factorial*j;
            }
            sum+=factorial;
        }

        return sum;
    }
/**
 *  3. 获取以n个2为中心轴，这组数据的和
 *  例如2+22+222+2222+22222+2222+222+22+2
 */
    public static int sum2(int n){
        int sum=0,temp=0;
        for (int i = 1; i <= n; i++) {
            temp=temp*10+2;
            if (i!=n) {
                sum+=temp*2;
            } else {
                sum+=temp;
            }
        }
        return sum;
    }

/**
 *  4. 获取1/2+2/3+3/5……. n个这样的和
 *  */
    public static double sumFraction(int n){
        int numerator=1;        //分子
        int denominator=2;        //分母
        double sum=0;
        for (int i = 0; i < n; i++) {
            sum +=(double)numerator/denominator;
            denominator+=numerator;
            numerator++;

        }
        return sum;
    }
}
