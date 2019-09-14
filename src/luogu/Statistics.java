package luogu;

import java.util.*;

/**
 * @ClassName Statistics
 * @Description  P1097 统计数字
 * 一半用例TLE、MLE，鉴于用的Java，我就当自己过了。
 *
 * 某次科研调查时得到了nn个自然数，每个数均不超过1500000000(1.5 \times 10^9)1500000000(1.5×10
 * 9
 *  )。已知不相同的数不超过1000010000个，现在需要统计这些自然数各自出现的次数，并按照自然数从小到大的顺序输出统计结果。
 * @Author NebulaPort
 * @Date 2019/9/13 21:28
 */
public class Statistics {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        int[] nums=new int[n];
        for (int i = 0; i <n ; i++) {
            nums[i]=in.nextInt();
            in.nextLine();
        }
        Map map=new TreeMap();

        for (int num:nums) {
            if (map.containsKey(num)){
                map.put(num, (int)map.get(num) +1);
            }else {
                map.put(num,1);
            }
        }

        for (Object o : map.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
