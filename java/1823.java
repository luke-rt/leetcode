class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> friends = new ArrayList<>();
        if(n == 1) return 1;
        for(int i = 0; i < n; ++i) friends.add(i);

        int idx = 0;

        for(int i = 0; i < n-1; ++i) {
            for(int count = 0; count < k-1; ++count) {
                if(idx == friends.size()-1) {
                    idx = 0;
                } else {
                    ++idx;
                }
            }

            friends.remove(idx);
            if(idx == friends.size()) {
                idx = 0;
            }
        }

        return friends.get(0)+1;
    }
}
