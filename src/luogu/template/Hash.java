package luogu.template;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName Hash
 * @Description  P3370 【模板】字符串哈希
 * 如题，给定N个字符串（第i个字符串长度为Mi，字符串内包含数字、大小写字母，大小写敏感），
 * 请求出N个字符串中共有多少个不同的字符串。
 * @Author NebulaPort
 * @Date 2019/9/16 10:44
 */
public class Hash {
    static long ans=0;
    static int prime=23333;
    static int base=131;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        Map map=new HashMap();
        for (int i = 0; i <n ; i++) {
            String str=in.nextLine();
            if (!map.containsKey(hash(str))){
                map.put(hash(str),str);
            }
        }
        System.out.println(map.size());


    }
    private static long hash(String str){
        ans=0;
        for (int i = 0; i <str.length() ; i++) {
            ans+=ans*base+str.charAt(i)+prime;
        }
        return ans;
    }
}
