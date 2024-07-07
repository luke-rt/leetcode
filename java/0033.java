class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left <= right) {
            int median = (left+right)/2;

            if(target > nums[median]) {
                if(nums[right] >= nums[median]) {
                    if(target > nums[right]) right = median-1;
                    else left = median+1;
                } else {
                    left = median+1;
                }
            } else if(target < nums[median]) {
                if(nums[left] <= nums[median]) {
                    if(target < nums[left]) left = median+1;
                    else right = median-1;
                } else {
                    right = median-1;
                }
            } else {
                return median;
            }
        }

        return -1;
    }
}
