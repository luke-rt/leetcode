class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;

        while (numBottles >= numExchange) {
            int tmp = numBottles / numExchange;
            ans += tmp;
            numBottles -= tmp * (numExchange-1);
        }

        return ans;
    }
}
