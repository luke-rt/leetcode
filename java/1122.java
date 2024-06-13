class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freq = new int[1001];
        for(int num : arr1) {
            ++freq[num];
        }

        int[] ans = new int[arr1.length];
        int index = 0;

        for(int num : arr2) {
            for(int i = 0; i < freq[num]; ++i) {
                ans[index] = num;
                ++index;
            }
            freq[num] = 0;
        }

        for(int i = 0; i < 1001; ++i) {
            for(int j = 0; j < freq[i]; ++j) {
                ans[index] = i;
                ++index;
            }
        }

        return ans;
    }
}
