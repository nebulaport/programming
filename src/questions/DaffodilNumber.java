package questions;

/**
 * @ClassName DaffodilNumber
 * @Description 找出1000以内的水仙花数
 * 1、水仙花数是指一个 n 位数 ( n>=3 )，
 * 它的每个位上的数字的 n 次幂之和等于它本身。
 * （例如：1^3 + 5^3 + 3^3 = 153）
 * @Author NebulaPort
 * @Date 2019/7/30 19:26
 */
public class DaffodilNumber {
    public static void main(String[] args) {
        int units,tens,hundreds;
        //一位数
        for (int i = 1; i < 10; i++) {
            System.out.println(i);
        }
        //两位数
        for (int i = 10; i <100 ; i++) {
            units=i%10;
            tens=i/10;
            int sum=(int) (units*units*tens*tens);
            if(i==sum){
                System.out.println(i);
            }
        }
        //三位数
        for(int i=100;i<1000;i++){
            units=i%10;
            tens=i/10%10;
            hundreds=i/100;
            int sum=(int) (Math.pow(units,3)+Math.pow(tens, 3)+Math.pow(hundreds, 3));
            if(i==sum){
                System.out.println(i);
            }
        }
    }
}
