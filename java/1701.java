class Solution {
    public double averageWaitingTime(int[][] customers) {
        int time = customers[0][0] + customers[0][1];
        double sum = customers[0][1];

        for(int i = 1; i < customers.length; ++i) {
            if(time > customers[i][0]) {
                sum += time - customers[i][0] + customers[i][1];
                time += customers[i][1];
            } else {
                sum += customers[i][1];
                time = customers[i][0] + customers[i][1];
            }
        }

        return sum / customers.length;
    }
}
