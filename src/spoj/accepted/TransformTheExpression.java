package spoj.accepted;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName TransformTheExpression
 * @Description Transform the Expression
 * Transform the algebraic expression with brackets into RPN form (Reverse Polish Notation).
 * Two-argument operators: +, -, *, /, ^ (priority from the lowest to the highest), brackets ( ).
 * Operands: only letters: a,b,...,z. Assume that there is only one RPN form (no expressions like a*b*c).
 *
 * Input
 * t [the number of expressions <= 100]
 * expression [length <= 400]
 * [other expressions]
 * Text grouped in [ ] does not appear in the input file.
 *
 * Output
 * The expressions in RPN form, one per line.
 *
 * ((a + (b * c)) - (d + e))
 * 转换中缀与后缀表达式后缀：把运算符号移动到对应的括号后面。
 * ((a (b c) * ) + (d e) + ) -
 * 把括号去掉，即得到了后缀表达式
 * a b c * + d e + -
 *
 * @Author NebulaPort
 * @Date 2019/8/22 11:21
 */
public class TransformTheExpression {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        String[] strArray=new String[n];
        for (int i = 0; i < n; i++) {
            strArray[i]=in.nextLine();
        }
        for (int i = 0; i <n ; i++) {
            System.out.println(getRPN(strArray[i]));
        }

    }
    private static String getRPN(String s){
        ArrayList a=new ArrayList<Character>();
        StringBuilder sb=new StringBuilder(s);
        int i=0;
        while (i<sb.length()){
            if (sb.charAt(i)=='+'||sb.charAt(i)=='-'||sb.charAt(i)=='*'||sb.charAt(i)=='/'||sb.charAt(i)=='^'){
                a.add(sb.charAt(i));
                sb.deleteCharAt(i);
                i--;
            }
            if (sb.charAt(i)==')'){
                sb.deleteCharAt(i);
                sb.insert(i, a.get(a.size()-1));

                a.remove(a.size()-1);
             }
            i++;

        }

        return  sb.toString().replace("(","");
    }
}
