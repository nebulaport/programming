package luogu;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName AMinusB
 * @Description  P1102 A-B 数对
 *
 * 给出一串数以及一个数字 C，要求计算出所有 A-B=C 的数对的个数。
 * （不同位置的数字一样的数对算不同的数对）
 * @Author NebulaPort
 * @Date 2019/9/16 11:08
 */
public class AMinusB {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int c=in.nextInt();
        in.nextLine();
        int[]nums=new int[n];
        Map<Integer,Integer> map=new HashMap();
        for (int i = 0; i <n ; i++) {
            nums[i]=in.nextInt();
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }

        }

        long ans=0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i]-c)){
                if (nums[i]==(nums[i]-c)){
                    ans+=map.get(nums[i]-c)-1;
                }else {
                    ans+=map.get(nums[i]-c);
                }
            }
        }
        System.out.println(ans);
    }
}
