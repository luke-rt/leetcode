class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] except = new int[n];
        int left = 1;

        for(int i = 0; i < n; ++i) {
            except[i] = left;
            left *= nums[i];
        }

        int right = 1;
        for(int i = n-1; i >= 0; --i) {
            except[i] *= right;
            right *= nums[i];
        }

        return except;
    }
}
