package luogu;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @ClassName MergeFruits
 * @Description P1090 合并果子
 * @Author NebulaPort
 * @Date 2019/9/17 23:08
 */
public class MergeFruits {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        //跟哈夫曼树的求法一样嘛
        PriorityQueue<Integer> pq=new PriorityQueue();
        for (int i = 0; i <n ; i++) {
            pq.add(in.nextInt());
        }
        int ans=0;
        while (pq.size()>1){
           int f1=pq.poll();
           int f2=pq.poll();
           ans+=f1+f2;
           pq.add(f1+f2);
        }
        System.out.println(ans);
    }
}
