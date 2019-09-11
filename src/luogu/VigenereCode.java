package luogu;

import java.util.Scanner;

/**
 * @ClassName VigenereCode
 * @Description  P1079 Vigenère 密码
 * @Author NebulaPort
 * @Date 2019/9/11 9:49
 */
public class VigenereCode {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String K=in.nextLine();
        String C=in.nextLine();
        char[] k=K.toCharArray();
        char[] c=C.toCharArray();
        for (int i = 0; i <k.length ; i++) {
            if (k[i]<97){
                k[i]+=32;
            }
        }


        int i=0;
        char[] m=new char[c.length];
        while(i<c.length){
            for (int j = 0; j <k.length ; j++) {
                if (c[i]>=97){
                    if ((c[i]+97-k[j])>=97) {
                        m[i]=(char)(c[i]+97-k[j]);
                    }else{
                        m[i]=(char)(c[i]+97-k[j]+26);
                    }
                }else{
                    if ((c[i]+97-k[j])>=65) {
                        m[i]=(char)(c[i]+97-k[j]);
                    }else{
                        m[i]=(char)(c[i]+97-k[j]+26);
                    }
                }

                i++;
                if (i>=c.length){
                    break;
                }
            }
        }
        for (int j = 0; j <m.length ; j++) {
            System.out.print(m[j]);
        }
    }
}
