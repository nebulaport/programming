package luogu;

import java.util.Scanner;

/**
 * @ClassName TreeBeford
 * @Description  P1030 求先序排列
 * @Author NebulaPort
 * @Date 2019/9/7 16:11
 */
public class TreeBeford {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String inord=in.nextLine();
        String aftord=in.nextLine();
        beford(inord,aftord);
    }
    private static void beford(String inord,String aftord){
        if ("".equals(inord)){
            return;
        }
        char root=aftord.charAt(aftord.length()-1);

        System.out.print(root);
        int idx=inord.indexOf(root);
        beford(inord.substring(0,idx),aftord.substring(0,idx));
        beford(inord.substring(idx+1),aftord.substring(idx,aftord.length()-1));
    }
}
