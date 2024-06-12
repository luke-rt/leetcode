class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int num : nums) s.add(num);

        int max = 0;
        for(int num : s) {
            if(!s.contains(num-1)) {
                // start of sequence
                int count = 1;
                int next = num+1;
                while(s.contains(next)) {
                    ++count;
                    ++next;
                }
                if(count > max) max = count;
            }
        }

        return max;
    }
}
