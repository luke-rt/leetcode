class Solution {
    public boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);
        
        while(left <= right) {
            long val = (left * left) + (right * right);
            if(val > c) --right;
            else if(val < c) ++left;
            else return true;
        }
        return false;
    }
}
