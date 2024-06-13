class Solution {
    public int heightChecker(int[] heights) {
        int[] sorted = heights.clone();
        Arrays.sort(sorted);

        int count = 0;
        for(int i = 0; i < heights.length; ++i) {
            if(sorted[i] != heights[i]) ++count;
        }
        return count;
    }
}
