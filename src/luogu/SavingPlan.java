package luogu;

import java.util.Scanner;

/**
 * @ClassName SavingPlan
 * @Description p1089 津津的储蓄计划
 * @Author NebulaPort
 * @Date 2019/9/12 9:50
 */
public class SavingPlan {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int[] plan=new int[12];
        for (int i = 0; i <12 ; i++) {
            plan[i]=in.nextInt();
            in.nextLine();
        }
        int least=0,save=0;
        boolean isEnough=true;
        for (int i = 0; i <12 ; i++) {
            if (plan[i]>300+least){
                System.out.println("-"+(i+1));
                isEnough=false;
                break;
            }
            least+=300-plan[i];
            save+=(least/100)*100;
            least=least%100;

        }
        if (isEnough){
            System.out.println((int)(save*1.2+least));
        }

    }
}
