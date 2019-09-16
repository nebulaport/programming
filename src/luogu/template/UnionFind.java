package luogu.template;

import java.util.Scanner;

/**
 * @ClassName UnionFind
 * @Description  P3367 【模板】并查集
 * 70分，MLE
 * @Author NebulaPort
 * @Date 2019/9/15 22:27
 */
public class UnionFind {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        in.nextLine();
        int[]op=new int[m];
        int[]num1=new int[m];
        int[]num2=new int[m];
        for (int i = 0; i < m; i++) {
            op[i]=in.nextInt();
            num1[i]=in.nextInt();
            num2[i]=in.nextInt();
            in.nextLine();
        }
        int[]f=new int[n+1];
        for(int i=1;i<=n;i++) {
            f[i]=i;
        }
        for (int i = 0; i <m ; i++) {
            if (op[i]==1){
                f[find(num1[i],f)]=find(num2[i],f);
            }else {
                if (find(num1[i],f)==find(num2[i],f)){
                    System.out.println("Y");
                }else{
                    System.out.println("N");
                }
            }
        }
    }
    private static int find(int k,int[] f){
        if (f[k]==k){return k;}
        return f[k]=find(f[k],f);
    }
}
