package spoj;

/**
 * @ClassName EASYPROB
 * @Description TODO:A Very Easy Problem!
 * Input
 * There's no input.
 *
 * Output
 * Output some form of these numbers: 137, 1315, 73, 136, 255, 1384, 16385,
 * one per line in the listed order.
 *
 * Example
 * The first two lines of the CORRECT output file are:
 *
 * 137=2(2(2)+2+2(0))+2(2+2(0))+2(0)
 * 1315=2(2(2+2(0))+2)+2(2(2+2(0)))+2(2(2)+2(0))+2+2(0)
 * The correct output file should contain 7 lines.
 * Question :EASYPROB - A Very Easy Problem!
 * The expansion is power.Eg 137= 2^(2^2 +2+ 2^0)+2^(2+2^0)+2^0
 * Eg.137 is 10001001
 * 1 Now, To find the first (leftmost) set bit ,
 * you can use k=log(num)/log(2).(gives you 7 as 7th bit is set)
 * 2 Then to remove that first set bit ,you substract num=num-2^k.
 * This gives you resultant number.(gives you 1001)
 * Now Repeat the above steps until num is 0
 * @Author NebulaPort
 * @Date 2019/8/28 16:42
 */
public class EASYPROB {
    public static void main(String[] args) {

    }
}
