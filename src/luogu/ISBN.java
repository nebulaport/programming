package luogu;

import java.util.Scanner;

/**
 * @ClassName ISBN
 * @Description P1055 ISBN号码
 * 每一本正式出版的图书都有一个ISBN号码与之对应，ISBN码包括99位数字、11位识别码和33位分隔符，其规定格式如x-xxx-xxxxx-x，
 * 其中符号-就是分隔符（键盘上的减号），最后一位是识别码，例如0-670-82162-4就是一个标准的ISBN码
 * ISBN码的首位数字表示书籍的出版语言，例如00代表英语；第一个分隔符-之后的三位数字代表出版社，例如670670代表维京出版社；
 * 第二个分隔符后的五位数字代表该书在该出版社的编号；最后一位为识别码。
 *
 * 识别码的计算方法如下：
 *
 * 首位数字乘以11加上次位数字乘以22……以此类推，用所得的结果\bmod 11mod11，所得的余数即为识别码，如果余数为1010，则识别码为大写字母XX。
 * 例如ISBN号码0-670-82162-4中的识别码44是这样得到的：对067082162这99个数字，从左至右，分别乘以1,2,...,91,2,...,9再求和，
 * 即0×1+6×2+……+2×9=1580×1+6×2+……+2×9=158，然后取158 \bmod 11158mod11的结果44作为识别码。
 *
 * 你的任务是编写程序判断输入的ISBN号码中识别码是否正确，如果正确，则仅输出Right；如果错误，则输出你认为是正确的ISBN号码。
 * @Author NebulaPort
 * @Date 2019/9/11 16:37
 */
public class ISBN {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String isbn=in.nextLine();
        String tmp=isbn.replace("-","");
        int sum=0;
        for (int i = 0; i <9 ; i++) {
            sum+=((int)tmp.charAt(i)-48)*(i+1);
        }
        int m=sum%11;
        if (m==10){
            if (isbn.charAt(isbn.length()-1)=='X'){
                System.out.println("Right");
            }else {
                System.out.print(isbn.substring(0,isbn.length()-1)+"X");
            }
        }else{
            if ((int)isbn.charAt(isbn.length()-1)==m+48){
                System.out.println("Right");
            }else{
                System.out.print(isbn.substring(0,isbn.length()-1)+m);
            }
        }
    }
}
