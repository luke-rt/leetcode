class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long sum = 0;
        for(int p : piles) sum += p;

        // sum/h <= ans <= sum/(h - piles.length+1)
        int min = (int) Math.ceilDiv(sum, h);
        int max = (int) Math.ceilDiv(sum, h-piles.length+1);

        int median = (min+max)/2;
        while(min < max) {
            int count = 0;
            for(int p : piles) {
                count += Math.ceilDiv(p, median);
            }

            if(count > h) min = median+1;
            else max = median;

            median = (min+max)/2;
        }

        return median;
    }
}
