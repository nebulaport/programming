package leetcode;

/**
 * @ClassName MaxSubArray
 * @Description  53. Maximum Subarray
 * Given an integer array nums, find the contiguous subarray
 * (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution,
 * try coding another solution using the divide and conquer approach, which is more subtle.
 * @Author NebulaPort
 * @Date 2019/8/31 9:37
 */
public class MaxSubArray {
    public static void main(String[] args) {

        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray2(nums));
        System.out.println(maxSubArray3(nums,0,nums.length));
        System.out.println(maxSubArray4(nums));
    }
    /**
     * dynamic programming O(n)
     * */
    private static int maxSubArray(int[] nums) {
        int maxSoFar=nums[0], maxEndingHere=nums[0];
        for (int i=1;i<nums.length;++i){
            maxEndingHere= Math.max(maxEndingHere+nums[i],nums[i]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
    /**
     * dynamic programming O(n)
     * */
    private static int maxSubArray2(int[] nums) {
        int sum = 0, smax = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            smax = Math.max(smax, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return smax;
    }
    /**
     * divide-and-conquer O(nlogn)
     * */
    private static int maxSubArray3(int[] nums, int lo,int hi) {
        //只有一个元素，则直接返回
        if (hi-lo<2){
            return nums[lo];
        }
        int mi=(lo+hi)/2;
        int gsL=nums[mi-1],sL=0,i=mi;
        //所有[i,mi)区段
        while (i-->lo){
            sL+=nums[i];
            if (gsL<sL){
                gsL=sL;
            }
        }
        int gsR=nums[mi],sR=0,j=mi-1;
        //所有[mi，j)区段
        while (++j<hi){
            sR+=nums[j];
            if (gsR<sR){
                gsR=sR;
            }
        }
        return Math.max(gsL+gsR,Math.max(maxSubArray3(nums,lo,mi),maxSubArray3(nums,mi,hi)));
    }
    /**
     * derease-and-conquer O(n)
     * */
    private static int maxSubArray4(int[] nums){
        int gs=nums[0],s=0,i=nums.length;
        while (i-->0){
            s+=nums[i];
            if (gs<s){
                gs=s;
            }

            if (s<=0){
                s=0;
            }
        }
        return gs;
    }

}
