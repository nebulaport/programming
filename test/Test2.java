/**
 * @ClassName Test2
 * @Description
 * @Author NebulaPort
 * @Date 2019/10/10 22:13
 */
public class Test2 {

    public static void main(String[] args) {
        Integer i=1;
        Integer j=1;
        System.out.println(i==j);
        System.out.println(i.equals(j));
        String str1="hello";
        String str2=str1;
        String str3="he"+new String("llo");
        String str4="hello";
        System.out.println(str1==str2);
        System.out.println(str1==str3);
        System.out.println(str1==str4);

    }


}
