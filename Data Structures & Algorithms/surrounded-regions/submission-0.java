class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int m = 0; m < rows; m++) {
            for (int n = 0; n < cols; n++) {
                if (m==0||n==0||m==rows-1||n==cols-1) {
                    if (board[m][n]=='O') markBoard(m, n, board);
                } 
            }
        }

        for (int m = 0; m < rows; m++) {
            for (int n = 0; n < cols; n++) {
                if (board[m][n]=='O') board[m][n] = 'X';
                else if (board[m][n]=='#') board[m][n] = 'O';
            }
        }
    }

    private void markBoard(int m, int n, char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        if (m<0||n<0||m>=rows||n>=cols||board[m][n]!='O') return;

        board[m][n] = '#';

        markBoard(m+1, n, board);
        markBoard(m-1, n, board);
        markBoard(m, n+1, board);
        markBoard(m, n-1, board);
    }
}
