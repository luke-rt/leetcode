import java.util.Arrays;

public class P2870 {
    /**
     * https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/
     */
    public static void main(String[] args) {
        System.out.println(P2870.minOperations(new int[]{2,2,2,2,3,3,3,4,4}));
    }

    /**
     *
     * sort array (organizes same values into groups)
     * iterate thru each group of same nums, get length of group
     * total += len / 3
     * if len % 3 is 1 or 2, then total++
     * get max total
     */
    public static int minOperations(int[] nums) {
        Arrays.sort(nums);

        int pos = 0;

        int total = 0;
        while(pos < nums.length) {
            // 2 2 2 2 3 3 3 4 4
            int i = pos;
            while(i < nums.length && nums[i] == nums[pos]) ++i;

            int count = i - pos;

            if(count == 1) return -1;

            total += count / 3;
            if(count % 3 != 0) ++total;

            pos = i;
        }

        return total;
    }
}
