import java.util.*;

class Solution {
    // similiar to #523
    public int subarraysDivByK(int[] nums, int k) {
        int[] freq = new int[k];
        freq[0] = 1; // old: count += freq[0]; same math as just adding another instance
        int count = 0;

        int tmp = 0;
        for(int i = 0; i < nums.length; ++i) {
            tmp = (tmp + nums[i]) % k;
            if(tmp < 0) tmp += k;

            // initial freq: 3, adding new instance means 3 new ordered pairs of values
            count += freq[tmp]; 
            ++freq[tmp];
        }

        return count;
    }
}

