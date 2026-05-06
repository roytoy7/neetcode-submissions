class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rSet = new HashSet<>();
            HashSet<Character> cSet = new HashSet<>();
            for (int n=0; n < 9;n++){
                // check rows
                if (board[i][n]!='.'){
                    if (rSet.contains(board[i][n])) return false;
                    else rSet.add(board[i][n]);
                }
                // check columns
                if (board[n][i]!='.'){
                    if (cSet.contains(board[n][i])) return false;
                    else cSet.add(board[n][i]);
                }
                
            }
        }
        for (int a=0; a<3; a++){
            HashSet<Character> rSet = new HashSet<>();
            HashSet<Character> cSet = new HashSet<>();
            for (int n=0; n< 3; n++){
                for (int i = 0; i < 3; i++){
                    // check rows
                    if (board[3*a+i][n]!='.'){
                        if (rSet.contains(board[3*a+i][n])) return false;
                        else rSet.add(board[3*a+i][n]);
                    }
                    // check columns
                    if (board[n][3*a+i]!='.'){
                        if (cSet.contains(board[n][3*a+i])) return false;
                        else cSet.add(board[n][3*a+i]);
                    }
                }
                
            }
        }
        
        return true;
    }
}
