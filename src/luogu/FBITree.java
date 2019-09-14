package luogu;

import java.util.Scanner;

/**
 * @ClassName FBITree
 * @Description  P1087 FBI树
 * 我们可以把由“0”和“1”组成的字符串分为三类：全“0”串称为B串，全“1”串称为I串，既含“0”又含“1”的串则称为F串。
 *
 * FBI树是一种二叉树，它的结点类型也包括FF结点，BB结点和I结点三种。由一个长度为2^N的“01”串S可以构造出一棵FBI树TT，递归的构造方法如下：
 *
 * T的根结点为R，其类型与串S的类型相同；
 * 若串S的长度大于1，将串S从中间分开，分为等长的左右子串S1和S2；由左子串S
 * 1构造R的左子树T1，由右子串S2构造RR的右子树T2。
 * 现在给定一个长度为2^N的“01”串，请用上述构造方法构造出一棵FBI树，并输出它的后序遍历序列。
 * @Author NebulaPort
 * @Date 2019/9/13 15:44
 */
public class FBITree {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        String str=in.nextLine();
        beford(str);

    }
    private static void beford(String str){
       if (str.length()>1){
           beford(str.substring(0,str.length()/2));
           beford(str.substring(str.length()/2));
       }
        System.out.print(FBI(str));
    }
    private static char FBI(String str){
        if (str.contains("0")){
            if (str.contains("1")){return 'F';}
            return 'B';
        }
        return 'I';
    }
}
