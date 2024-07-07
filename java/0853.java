class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        float[] times = new float[target];
        for(int i = 0; i < position.length; ++i) {
            times[position[i]] = (float)(target - position[i]) / speed[i];
        }

        int count = 0;
        float time = 0;
        for(int i = target-1; i >= 0; --i) {
            if(times[i] > time) {
                time = times[i];
                ++count;
            }
        }

        return count;
    }
}
