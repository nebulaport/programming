package spoj;


import java.util.Scanner;

/**
 * @ClassName TheNextPalindrome
 * @Description TODO:The Next Palindrome （未AC，找不到错）
 * A positive integer is called a palindrome
 * if its representation in the decimal system is the same when read from left to right and from right to left.
 * For a given positive integer K of not more than 1000000 digits,
 * write the value of the smallest palindrome larger than K to output.
 * Numbers are always displayed without leading zeros.
 * <p>
 * Input
 * The first line contains integer t, the number of test cases. Integers K are given in the next t lines.
 * <p>
 * Output
 * For each K, output the smallest palindrome larger than K.
 * @Author NebulaPort
 * @Date 2019/8/23 9:55
 */
public class TheNextPalindrome {
    //    public static void main(String[] args) {
//
//        Scanner in= new Scanner(System.in);
//        int n=in.nextInt();
//        int[] num=new int[n];
//        for (int i = 0; i < n; i++) {
//            num[i]=in.nextInt();
//        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(getNextPalindrome(num[i]));
//        }
//
//
//    }
//    private static int getNextPalindrome(int num){
//
//        while(!ifPalindrome(++num)){}
//        return num;
//    }
//    private static boolean ifPalindrome(int n){
//
//        if (n%10==0){
//            return false;
//        }
//        int reverse=0;
//        int temp=n;
//
//        while(n>0){
//            reverse*=10;
//            reverse+=(n%10);
//            n=n/10;
//        }
//
//        return reverse == temp;
//    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        if (in.hasNextInt()) {
            n = in.nextInt();
            in.nextLine();
        }

        String[] input = new String[n];
        for (int i = 0; i < n; i++) {
            input[i] = in.nextLine();
        }
        for (int i = 0; i < n; i++) {
            System.out.println(getNextPalindrome(input[i]));

        }

    }

    private static String getNextPalindrome(String num) {


        char[] c = addOne(num).toCharArray();

        if (c[0] == '-') {
            return "0";
        }

        int len = c.length;
        if (len==1){
            return String.valueOf(c);
        }

        for (int i = 0; i < len / 2; i++) {
            if (c[len / 2 - i - 1] != c[((len + 1) / 2) + i]) {

                //左边大
                if (c[len / 2 - i - 1] > c[((len + 1) / 2) + i]) {
                    for (int j = 0; j < len / 2 - i; j++) {
                        c[len-1- j] = c[j];
                    }
                    return String.valueOf(c);
                }else {
                    //右边大
                    for (int j = ((len+1)/2)-1; j >=0 ; j--) {
                        if (c[j]!='9'){
                            c[j]++;
                            for (int k = j+1; k <= (len+1)/2; k++) {
                                c[k]='0';
                            }
                            for (int k = 0; k < len/2; k++) {
                                c[len-1 - k] = c[k];
                            }
                            return String.valueOf(c);
                        }
                    }
                    for (int j = 0; j <len-1 ; j++) {
                        c[i]='0';
                    }
                    c[len-1]='1';
                    return "1"+ String.valueOf(c);

                }

            }
        }
        return String.valueOf(c);

    }

    private static String addOne(String num) {
        StringBuffer sb = new StringBuffer(num);
        int len = sb.length();

        for (int i = 0; i < len; i++) {
            if (sb.charAt(len - 1 - i) != '9') {
                int n=Character.getNumericValue(sb.charAt(len - 1 - i));

                n++;
                sb.deleteCharAt(len - 1 - i);
                sb.insert(len - 1 - i, n);

                if (i > 0) {
                    sb.delete(len - i, -1);
                    for (int j = 0; j < i; j++) {
                        sb.append(0);
                    }
                }
                return sb.toString();

            }

        }
        sb.delete(0, len);
        sb.append(1);
        for (int i = 0; i < len; i++) {
            sb.append(0);
        }
        return sb.toString();

    }

}
