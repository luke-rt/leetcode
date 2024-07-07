class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        while(left < right) {
            int median = (left+right)/2;

            if(nums[median] > nums[right]) {
                left = median+1;
            } else {
                right = median;
            }
        }

        return nums[left];
    }
}
