import java.util.*;

class Solution {
    /**
     *
     * store all remainders of prefix sums divided by k
     * prefix sum: jth - ith prefix sum = subarray index i to j;
     * if remainders of two prefix sums are equal, then subarray sum is divisible by k
     * thus store key: remainder, value: index
     * for every index in remainder array, if key exists return true if difference of indices > 1
    **/
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

        int tmp = nums[0] % k;
        mp.put(tmp, 0);

        for(int i = 1; i < nums.length; ++i) {
            tmp = (tmp + nums[i]) % k;
            if(tmp == 0) return true;

            Integer index = mp.get(tmp);
            if(index == null) {
                mp.put(tmp, i);
            } else {
                if(i - index > 1) return true;
            }
        }

        
        return false;
    }
}
