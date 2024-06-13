public class P1863 {
    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[] { 1, 3 }));
    }

    static int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);

    }

    static int helper(int[] nums, int index, int acc) {
        if (index == nums.length) {
            return acc;
        }

        return helper(nums, index + 1, acc ^ nums[index]) + helper(nums, index + 1, acc);

    }
}
