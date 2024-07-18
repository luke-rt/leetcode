class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        final int N = nums1.length + nums2.length;
        final int HALF = (N + 1)/2;

        int left = 0;
        int right = nums1.length;

        while(left <= right) {
            int m1 = (left+right)/2;
            int m2 = HALF - m1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if(m1-1 >= 0) l1 = nums1[m1-1];
            if(m2-1 >= 0) l2 = nums2[m2-1];
            if(m1 < nums1.length) r1 = nums1[m1];
            if(m2 < nums2.length) r2 = nums2[m2];

            if(l1 > r2) right = m1-1;
            else if(l2 > r1) left = m1+1;
            else {
                if(N % 2 == 0) {
                    return ((double)Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            }
        }

        return 0;
    }
}

