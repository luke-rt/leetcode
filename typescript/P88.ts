/**
 Do not return anything, modify nums1 in-place instead.
 */
 function merge(nums1: number[], m: number, nums2: number[], n: number): void {
    let j = m-1;
    let k = n-1;

    while(k >= 0) {
        if(nums1[j] == undefined || nums2[k] > nums1[j]) {
            nums1[j+k+1] = nums2[k--];
        } else {
            nums1[j+k+1] = nums1[j--];
        }
    }
};
