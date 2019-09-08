package camp;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @ClassName ReCode
 * @Description 重编码
 * 问题描述
 * 有一篇文章，文章包含 n 种单词，单词的编号从 1 至 n，第 i 种单词的出现次数为 w[i]。
 *
 * 现在，我们要用一个 2 进制串（即只包含 0 或 1 的串） s[i] 来替换第 i 种单词，使其满足如下要求：对于任意的 1≤i,j≤n（i≤j），都有 s[i] 不是 s[j] 的前缀。（这个要求是为了避免二义性）
 *
 * 你的任务是对每个单词选择合适的 s[i]，使得替换后的文章总长度（定义为所有单词出现次数与替换它的二进制串的长度乘积的总和）最小。求这个最小长度。
 *
 * 字符串 S1（不妨假设长度为 n）被称为字符串 S2 的前缀，当且仅当：S2 的长度不小于 n，且 S1 与 S2 前 n 个字符组组成的字符串完全相同。
 *
 * 输入格式
 * 第一行一个整数 n，表示单词种数。
 *
 * 第 2 行到第 n+1 行，第 i+1 行包含一个正整数 w[i]，表示第 i 种单词的出现次数。
 *
 * 输出格式
 * 输出一行一个整数，表示整篇文章重编码后的最短长度。

 * @Author NebulaPort
 * @Date 2019/8/21 20:25
 */
public class ReCode {
    public static void main(String[] args) {

       Scanner in= new Scanner(System.in);
        int n=in.nextInt();
        int[] w=new int[n];
        for (int i = 0; i < n; i++) {
            w[i]=in.nextInt();
        }
        System.out.println(huffman(w));

    }
    /**
     * 使用优先队列生成哈夫曼树
     * */
    static private int huffman(int[] w){
        PriorityQueue<Integer> pq =new PriorityQueue<Integer>();
        int sum=0;
        int s1,s2;
        for (int a : w) {
            pq.add(a);
        }
        while(pq.size()>1){
            s1= pq.poll();
            s2= pq.poll();
            sum+=s1;
            sum+=s2;
            pq.add(s1+s2);
        }
        return sum;
 }

}
