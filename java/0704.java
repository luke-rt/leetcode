class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left <= right) {
            int median = left + (right-left) / 2;

            if(nums[median] < target) left = median+1;
            else if(nums[median] > target) right = median-1;
            else return median;
        }

        return -1;
    }
}
