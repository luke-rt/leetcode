class Solution {
    public int passThePillow(int n, int time) {
        final int x = time / (n-1);
        return x % 2 == 0 ? 1+time-(x*(n-1)) : n-(time-(x*(n-1)));
    }
}
