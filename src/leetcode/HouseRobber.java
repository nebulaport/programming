package leetcode;

/**
 * @ClassName HouseRobber
 * @Description  House Robber
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 * @Author NebulaPort
 * @Date 2019/8/31 10:52
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] money={1,2,3,1};

        System.out.println(rob(money));

    }


    private static int rob(int[] money){
        int rob = 0;
        //max monney can get if rob current house
        int notrob = 0;
        //max money can get if not rob current house
        for(int i=0; i<money.length; i++) {
            int currob = notrob + money[i];
            //if rob current value, previous house must not be robbed
            notrob = Math.max(notrob, rob);
            //if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
            rob = currob;
        }
        return Math.max(rob, notrob);
    }
}
