class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) {
            Integer tmp = freq.getOrDefault(num, 0);
            freq.put(num, tmp + 1);
        }

        List[] buckets = new List[nums.length];

        for(Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int f = e.getValue() - 1;
            if(buckets[f] == null) {
                buckets[f] = new LinkedList<Integer>();
            }
            buckets[f].add(e.getKey());
        }

        int[] top = new int[k];
        int index = 0;
        int i = nums.length - 1;

        while(index < k && i >= 0) {
            if(buckets[i] != null) {
                for(Object e : buckets[i]) {
                    top[index] = (int) e;
                    ++index;
                }
            }
            --i;
        }

        return top;

    }
}
