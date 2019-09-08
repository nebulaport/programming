package questions;

import java.util.Scanner;

/**
 * @ClassName SumOfNumInStr
 * @Description  Sum of numbers in string
 * Given a string str containing alphanumeric characters,
 * calculate sum of all numbers present in the string.
 * @Author NebulaPort
 * @Date 2019/7/30 13:59
 */
public class SumOfNumInStr {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        scan.nextLine();
        while(t-->0){
            String s = scan.nextLine();
            int count=0;
            long sum =0;
            String[] ar = s.split("\\D");
            for(int i=0;i<ar.length;i++){
                if(!ar[i].isEmpty()){
                    sum += Integer.parseInt(ar[i]);
                }
            }
            System.out.println(sum);
        }
    }
}
