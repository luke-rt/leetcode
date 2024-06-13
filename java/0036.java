class Solution {
    public boolean isValidSudoku(char[][] board) {

        boolean[][] rows = new boolean[9][9];
        boolean[][][] boxes = new boolean[3][3][9];

        for(int col = 0; col < 9; ++col)  {

            boolean[] column = new boolean[9];
            for(int row = 0; row < 9; ++row) {
                if(board[col][row] == '.') continue;
                int val = board[col][row] - '0';

                if(column[val-1]) return false;
                column[val-1] = true;

                if(rows[row][val-1]) return false;
                rows[row][val-1] = true;

                if(boxes[col/3][row/3][val-1]) return false;
                boxes[col/3][row/3][val-1] = true;
            }
        }
        return true;
    }
}
