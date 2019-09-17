package luogu;

import java.util.Scanner;

/**
 * @ClassName MissileInterception
 * @Description  P1020 导弹拦截
 * 某国为了防御敌国的导弹袭击，发展出一种导弹拦截系统。但是这种导弹拦截系统有一个缺陷：
 * 虽然它的第一发炮弹能够到达任意的高度，但是以后每一发炮弹都不能高于前一发的高度。
 * 某天，雷达捕捉到敌国的导弹来袭。由于该系统还在试用阶段，所以只有一套系统，因此有可能不能拦截所有的导弹。
 *
 * 输入导弹依次飞来的高度（雷达给出的高度数据是\le 50000≤50000的正整数），
 * 计算这套系统最多能拦截多少导弹，如果要拦截所有导弹最少要配备多少套这种导弹拦截系统。
 * @Author NebulaPort
 * @Date 2019/9/17 13:57
 */
public class MissileInterception {
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        String[] input=in.nextLine().split(" ");
        int[] height=new int[input.length];
        for (int i = 0; i <input.length ; i++) {
            height[i]=Integer.parseInt(input[i]);
        }
        //第一问（最长不升子序列）
        int[]notRise=new int[height.length];
        notRise[0]=height[0];
        int j=0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] <= notRise[j]) {
                notRise[++j]=height[i];
            }else {
                int l=0,r=j;
                while (l<r){
                    int mid=l+(r-l)/2;
                    if (notRise[mid]>=height[i]){
                        l=mid+1;
                    }else{
                        r=mid;
                    }
                }
                notRise[r]=height[i];
            }
        }
        System.out.println(j + 1);

        //第二问（最长上升子序列）
        int[] rise = new int[height.length];
        rise[0] = height[0];
        j = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] > rise[j]) {
                rise[++j] = height[i];
            } else {
                int l = 0, r = j;
                while (l < r) {
                    int mid=l+(r-l)/2;
                    if (rise[mid] < height[i]) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                rise[r] = height[i];
            }
        }
        System.out.println(j+1);
    }

}
