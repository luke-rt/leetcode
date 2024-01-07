import java.util.*;

public class P300 {
    /**
     * https://leetcode.com/problems/longest-increasing-subsequence
     * Given an integer array nums, return the length of the longest strictly increasing
     * subsequence
     *
     */
    public static void main(String[] args) {
        int[] nums1 = {10,9,2,5,3,7,101,18,10,9,2,5,3,7,101,18};
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        int[] nums4 = {3,5,6,2,5,4,19,5,6,7,12};
        int[] nums5 = {2,3,1,2,3};
        int[] nums6 = {1,2,-10,-8,-7};
        System.out.println(P300.lengthOfLIS(nums1));
        System.out.println(P300.lengthOfLIS(nums2));
        System.out.println(P300.lengthOfLIS(nums3));
        System.out.println(P300.lengthOfLIS(nums4));
        System.out.println(P300.lengthOfLIS(nums5));
        System.out.println(P300.lengthOfLIS(nums6));
    }

    /**
     * Fill dynamic programming array with 1
     * for each element e in nums
     *      for every element before e
     *          set the corresponding dp value
     *          to 1 + maximum previous dp value
     *
     * return maximum dp value
     */
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        int max = 1;
        for(int i = 1; i < len; i++) {
            for(int j = 0; j < i; ++j) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}