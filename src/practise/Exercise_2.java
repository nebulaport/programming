package practise;
/**
* 2019/7/25
* 字符串，数组,面向对象
* */

public class Exercise_2 {
    public static void main(String[] args) {
        System.out.println(times(null,null));
        System.out.println(dereplication("121212123"));

        int[] items={1,2,3,4};
        arrayShift(items,2);

    }
   /**
    * 1. 查找某个字符串中任意指定字符串出现的次数。
    * */
    public static int times(String str,String tar){
            int times=0;
            if (tar!=null){
                int index=str.indexOf(tar);
                for (int i = 0; i < str.length(); i++){
                    if (index==-1){
                        break;
                    }else{
                        times++;
                        index++;
                        index=str.indexOf(tar,index);
                    }
                }
            }
            return times;
    }
    /**
     * 2. 将一个字符串去掉重复字符，获取无重复字符的字符串。
     * */
    public static String dereplication(String str){
        String s = "";
        while(!str.equals("")){
            char c=str.charAt(0);
            s=s+String.valueOf(c);
            str=str.replace(String.valueOf(c),"");
        }
        return s;
    }
/**    	3. 循环位移[1234] n 次，获取第n次该数组值。
 *          第一次：[2,3,4,1]
 *          第二次：[3,4,1,2]
 */
    public static void arrayShift(int[] items,int n){
        if(items!=null&&items.length>0){
            int temp=0;
            for (int i = 0; i < n; i++) {
                temp=items[0];
                for (int j = 0; j < items.length; j++) {
                    if (j+1>items.length-1){
                        items[j]=temp;
                        break;
                    }
                    items[j]=items[j+1];
                }
            }
        }
        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i]+",");
        }
    }
}
