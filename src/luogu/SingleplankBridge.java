package luogu;

import java.util.Scanner;

/**
 * @ClassName SingleplankBridge
 * @Description  P1007 独木桥
 * 题目背景
 * 战争已经进入到紧要时间。你是运输小队长，正在率领运输部队向前线运送物资。运输任务像做题一样的无聊。
 * 你希望找些刺激，于是命令你的士兵们到前方的一座独木桥上欣赏风景，而你留在桥下欣赏士兵们。士兵们十分愤怒，因为这座独木桥十分狭窄，只能容纳11个人通过。
 * 假如有22个人相向而行在桥上相遇，那么他们22个人将无妨绕过对方，只能有11个人回头下桥，让另一个人先通过。但是，可以有多个人同时呆在同一个位置。
 *
 * 题目描述
 * 突然，你收到从指挥部发来的信息，敌军的轰炸机正朝着你所在的独木桥飞来！为了安全，你的部队必须撤下独木桥。
 * 独木桥的长度为LL，士兵们只能呆在坐标为整数的地方。所有士兵的速度都为11，但一个士兵某一时刻来到了坐标为00或L+1L+1的位置，他就离开了独木桥。
 *
 * 每个士兵都有一个初始面对的方向，他们会以匀速朝着这个方向行走，中途不会自己改变方向。
 * 但是，如果两个士兵面对面相遇，他们无法彼此通过对方，于是就分别转身，继续行走。转身不需要任何的时间。
 *
 * 由于先前的愤怒，你已不能控制你的士兵。甚至，你连每个士兵初始面对的方向都不知道。
 * 因此，你想要知道你的部队最少需要多少时间就可能全部撤离独木桥。另外，总部也在安排阻拦敌人的进攻，因此你还需要知道你的部队最多需要多少时间才能全部撤离独木桥。
 * @Author NebulaPort
 * @Date 2019/9/6 15:03
 */
public class SingleplankBridge {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int L =in.nextInt();
        in.nextLine();
        int N =in.nextInt();
        in.nextLine();
        int[]a=new int[N];
        for (int i = 0; i <N ; i++) {
            a[i]=in.nextInt();
        }
       int min=0,max=0;
        for (int i = 0; i < N; i++) {
            min=Math.max(min,Math.min(a[i],L+1-a[i]));
            max=Math.max(max,Math.max(a[i],L+1-a[i]));
        }

        System.out.println(min+" "+max);
    }
}
