package leetcode;

import java.util.Stack;

/**
 * @ClassName IsValid
 * @Description
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。

 * @Author NebulaPort
 * @Date 2019/11/4 13:20
 */
public class IsValid {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(')');
            }else if(s.charAt(i)=='['){
                stack.push(']');
            }else if(s.charAt(i)=='{'){
                stack.push('}');
            }else{
                if(stack.empty()||stack.pop()!=s.charAt(i)){
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
