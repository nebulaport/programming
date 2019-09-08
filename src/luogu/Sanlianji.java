package luogu;

/**
 * @ClassName Sanlianji
 * @Description P1008 三连击
 * 将1,2, \cdots ,91,2,⋯,9共99个数分成33组，分别组成33个三位数，
 * 且使这33个三位数构成1:2:31:2:3的比例，试求出所有满足条件的33个三位数。
 * @Author NebulaPort
 * @Date 2019/9/5 9:23
 */
public class Sanlianji {
    public static void main(String[] args) {
        for(int i=100;i<=999;i++){
            if(i/100+i/10%10+i%10+(i*2)/100+(i*2)/10%10+(i*2)%10+(i*3)/100+(i*3)/10%10+(i*3)%10==45
                    &&(i/100)*(i/10%10)*(i%10)*(i*2/100)*(i*2/10%10)*(i*2%10)*(i*3/100)*(i*3/10%10)*(i*3%10)==362880) {
                System.out.println(i+" "+i*2+" "+i*3);

            }
        }
    }
}
