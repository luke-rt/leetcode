class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while(left < right) {
            int minHeight = Math.min(height[left], height[right]);
            max = Math.max(max, (right-left) * minHeight);

            while(left < right && height[right] <= minHeight) {
                --right;
            }
            while(left < right && height[left] <= minHeight) {
                ++left;
            }
        }

        return max;
    }
}
