package luogu;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName OnedimensionalEquation
 * @Description  P1022 计算器的改良

 * 为了很好的完成这个任务，ZL先生首先研究了一些一元一次方程的实例：
 * 4+3x=8
 * 6a-5+1=2-2a
 * -5+12y=0
 * ZL先生被主管告之，在计算器上键入的一个一元一次方程中，只包含整数、小写字母及+、-、=这三个数学符号（当然，符号“-”既可作减号，也可作负号）。
 * 方程中并没有括号，也没有除号，方程中的字母表示未知数。
 *
 * 你可假设对键入的方程的正确性的判断是由另一个程序员在做，或者说可认为键入的一元一次方程均为合法的，且有唯一实数解。
 * @Author NebulaPort
 * @Date 2019/9/10 15:02
 */
public class OnedimensionalEquation {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String input=in.nextLine();
        ArrayList xOptions=new ArrayList();
        ArrayList nums=new ArrayList();
        int i=1;
        int l=0;
        while (input.charAt(i)!='='){

            if (input.charAt(i)=='+'){
                if (input.charAt(i-1)>=97&&input.charAt(i-1)<=122){
                    xOptions.add(input.substring(l,i));
                }else {
                    nums.add(input.substring(l,i));
                }
                l=i+1;
            }
            if (input.charAt(i)=='-'){
                if (input.charAt(i-1)>=97&&input.charAt(i-1)<=122){
                    xOptions.add(input.substring(l,i));
                }else {
                    nums.add(input.substring(l,i));
                }
                l=i;
            }
            i++;
        }
        //等式左边那一项
        if (input.charAt(i-1)>=97&&input.charAt(i-1)<=122){
            xOptions.add(input.substring(l,i));
        }else {
            nums.add(input.substring(l,i));
        }
        //等式右边
        l=i+1;
        i++;
        while (++i<input.length()){
            if (input.charAt(i)=='+'||input.charAt(i)=='-'){
                if (input.charAt(l)=='-'){
                    if (input.charAt(i-1)>=97&&input.charAt(i-1)<=122){
                        xOptions.add(input.substring(l+1,i));
                    }else {
                        nums.add(input.substring(l+1,i));
                    }
                }else{
                    if (input.charAt(i-1)>=97&&input.charAt(i-1)<=122){
                        xOptions.add("-"+input.substring(l,i));
                    }else {
                        nums.add("-"+input.substring(l,i));
                    }
                }
                if (input.charAt(i)=='+'){
                    l=i+1;
                }else {
                    l=i;
                }

            }

        }
        //最后一项
        if (input.substring(l).charAt(0)=='-'){
            if (input.charAt(input.length()-1)>=97&&input.charAt(input.length()-1)<=122){

                xOptions.add(input.substring(l+1));
            }else {
                nums.add(input.substring(l+1));
            }
        }else if(input.substring(l).charAt(0)=='+'){
            if (input.charAt(input.length()-1)>=97&&input.charAt(input.length()-1)<=122){

                xOptions.add("-"+input.substring(l+1));
            }else {
                nums.add("-"+input.substring(l+1));
            }
        }else{
            if (input.charAt(input.length()-1)>=97&&input.charAt(input.length()-1)<=122){

                xOptions.add("-"+input.substring(l));
            }else {
                nums.add("-"+input.substring(l));
            }
        }

        double ans = 0;

        for (Object num : nums) {
            ans += (double)Integer.parseInt(String.valueOf(num));
        }
        double tmp=0;
        for (Object xOption : xOptions) {

            if (String.valueOf(xOption).length()==1){
                tmp--;
            }else if(String.valueOf(xOption).length()==2&&String.valueOf(xOption).charAt(0)=='-'){
                tmp++;
            }else{
                tmp -= (double) Integer.parseInt(String.valueOf(xOption).substring(0,String.valueOf(xOption).length()-1));
            }

        }
        ans=ans/tmp;
        char x=String.valueOf(xOptions.get(0)).charAt(String.valueOf(xOptions.get(0)).length()-1);
        DecimalFormat df = new DecimalFormat("#0.000");
        System.out.println(x+"="+df.format(ans));
    }
}
