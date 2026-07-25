class Solution {
    public boolean exist(char[][] board, String word) {
        char f = word.charAt(0);
        boolean found = false;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c]==f) {
                    board[r][c] = '#';
                    if (search(board, word, r, c, 1)) return true;
                    board[r][c] = f;
                }
            }
        } 
        return false;
    }

    private boolean search(char[][] board, String word, int r, int c, int ind) {
        if (ind==word.length()) return true;
        char f = word.charAt(ind);

        if (c>0 && f==board[r][c-1]) {
            board[r][c-1] = '#';
            if (search(board, word, r, c-1, ind+1)) return true;
            board[r][c-1] = f;
        }
        if (c<board[0].length-1 && f==board[r][c+1])  {
            board[r][c+1] = '#';
            if (search(board, word, r, c+1, ind+1)) return true;
            board[r][c+1] = f;
        }

        if (r>0 && f==board[r-1][c]) {
            board[r-1][c] = '#';
            if (search(board, word, r-1, c, ind+1)) return true;
            board[r-1][c] = f;
        }

        if (r<board.length-1 && f==board[r+1][c])  {
            board[r+1][c] = '#';
            if (search(board, word, r+1, c, ind+1)) return true;
            board[r+1][c] = f;
        }

        return false;
    }
   
}
