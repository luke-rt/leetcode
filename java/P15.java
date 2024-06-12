class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triples = new LinkedList<List<Integer>>();

        for(int curr = 0; curr < nums.length-2 && nums[curr] <= 0; ++curr) {
            if(curr > 0 && nums[curr] == nums[curr-1]) continue;

            int left = curr+1;
            int right = nums.length-1;

            while(left < right) {
                int val = nums[curr] + nums[left] + nums[right];
                if(val < 0) {
                    ++left;
                } else if(val > 0) {
                    --right;
                } else {
                    triples.add(Arrays.asList(nums[curr], nums[left], nums[right]));
                    do {
                        ++left;
                    } while(left < right && nums[left] == nums[left-1]);
                    do {
                        --right;
                    } while(left < right && nums[right] == nums[right+1]);
                }
            }
        }

        return triples;
    }
}
