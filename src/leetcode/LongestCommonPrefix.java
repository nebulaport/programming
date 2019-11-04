package leetcode;

/**
 * @ClassName LongestCommonPrefix
 * @Description
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * @Author NebulaPort
 * @Date 2019/11/4 13:19
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0){return "";}
        String prefix=strs[0];
        for(String str:strs){
            int i=0;
            while(i<str.length()&&i<prefix.length()){
                if(str.charAt(i)==prefix.charAt(i))
                    i++;
                else
                    break;
            }
            prefix=prefix.substring(0,i);
        }
        return prefix;

    }
}
