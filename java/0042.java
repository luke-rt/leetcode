class Solution {
    public int trap(int[] height) {
        final int N = height.length;
        int left = 0;
        int right = N-1;

        int maxLeft = 0;
        int maxRight = 0;

        int ans = 0;
        while(left < right) {
            if(height[left] < height[right]) {
                if(height[left] > maxLeft) maxLeft = height[left];
                else ans += maxLeft - height[left];
                ++left;
            } else {
                if(height[right] > maxRight) maxRight = height[right];
                else ans += maxRight - height[right];
                --right;
            }
        }

        return ans;
    }
}
