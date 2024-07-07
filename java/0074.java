class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix[0].length-1;

        int top = 0;
        int bottom = matrix.length-1;

        while(top <= bottom) {
            int v = top + (bottom - top) / 2;
            if(target > matrix[v][right]) top = v+1;
            else if(target < matrix[v][left]) bottom = v-1;
            else {
                while(left <= right) {
                    int h = left + (right-left) / 2;
                    if(target > matrix[v][h]) left = h+1;
                    else if(target < matrix[v][h]) right = h-1;
                    else return true;
                }
                return false;
            }
        }

        return false;
    }
}
