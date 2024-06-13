class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // sorted string as key, str as value
        Map<String, List<String>> mp = new HashMap<>();
        for(String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);

            // computeIfAbsent >:)
            // LinkedList > ArrayList since only appending to end of list
            // non random accesses or insertions
            mp.computeIfAbsent(sorted, k -> new LinkedList<>()).add(str);
        }

        // ArrayList > LinkedList here
        return new ArrayList<>(mp.values());
    }
}
