package camp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName Stack
 * @Description 栈程序
 * 时间限制：2s，空间256MB
 *
 * 问题描述
 * 实现一个栈，完成以下功能：
 *
 * 入栈
 * 出栈
 * 查询栈中位置Y是谁
 * 一开始栈为空，栈中的位置从1开始（即栈底位置为1）。
 *
 * 输入
 * 第一行一个整数n，表示操作个数（1 <= n <= 100000）
 *
 * 接下来n行，每行第一个数字表示操作（见描述）：
 *
 * 若为数字1，则接下来有一串字符串X，表示将X压入栈中。
 * 若为数字2，表示弹出栈顶（保证栈非空），并输出出栈的这个人。
 * 若为数字3，则接下来有一个整数Y，表示询问栈中位置Y是谁（保证位置Y合法），并输出名字。
 * 数据中的字符串只包含26个小写字母（无空格灯分隔符），且长度不超过15
 *
 * 字符串可能有重复，正如现实中可能有重名。
 *
 * 输出
 * 将所有操作2和操作3输出，一行一个。

 * @Author NebulaPort
 * @Date 2019/8/20 16:31
 */
public class Stack {
    private static int top;

    private static ArrayList<String> stack = new ArrayList<>();



    public static void main(String[] args) {
        int n;
        String name="";
        Scanner in=new Scanner(System.in);
        n=in.nextInt();

        for (int i = 0; i <n ; i++) {
            int op;
            op=in.nextInt();
            if (op==1){
                name=in.nextLine();
                push(name);
            }else if (op==2){
                System.out.println(pop());
            }else{
                int pos;
                pos=in.nextInt();
                System.out.println(query(pos));
            }

        }
    }

    private static void push(String name){
        top++;
        stack.add(name);

    }
    private static String pop(){
        String str=stack.get(top-1);
        stack.remove(stack.size()-1);
        return str;
    }
    private static String query(int pos){
        return stack.get(pos-1).toString();
    }

}
