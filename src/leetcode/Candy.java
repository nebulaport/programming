package leetcode;

/**
 * @ClassName Candy
 * @Description  135. Candy
 * There are N children standing in a line. Each child is assigned a rating value.
 *
 * You are giving candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * @Author NebulaPort
 * @Date 2019/9/10 9:35
 */
public class Candy {
    public static void main(String[] args) {
        int[] test1={1,0,2};
        int[] test2={1,2,2};
        System.out.println(candy(test1));
        System.out.println(candy(test2));

    }
    private static int candy(int[] ratings) {
        int[] candies=new int[ratings.length];
        for (int i = 0; i <candies.length ; i++) {
            candies[i]=1;
        }
        //从左到右
        for (int i = 1; i <candies.length ; i++) {
            if (ratings[i]>ratings[i-1]&&candies[i]<=candies[i-1]){
                candies[i]=candies[i-1]+1;
            }
        }
        //从右到左
        for (int i = candies.length-2; i >=0 ; i--) {
            if (ratings[i]>ratings[i+1]&&candies[i]<=candies[i+1]){
                candies[i]=candies[i+1]+1;
            }
        }
        int sum=0;
        for (int candy : candies) {
            sum += candy;
        }
        return sum;

    }
}
