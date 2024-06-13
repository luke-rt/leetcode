class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; ++i) {
            Integer index = mp.get(target - nums[i]);
            if(index != null) {
                return new int[]{ index, i };
            }
            mp.put(nums[i], i);
        }
        return new int[]{};
    }
}
